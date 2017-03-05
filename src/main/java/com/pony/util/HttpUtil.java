package com.pony.util;


import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


/**
 * http构造方法
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
public class HttpUtil {
    private static HttpClient httpClient = new DefaultHttpClient(new PoolingClientConnectionManager());

    public static <T> T getService(String url, Class<T> returnType, String... headers) {
        HttpGet get = new HttpGet(url);
        return execute(get, returnType, headers);
    }

    public static <T> T postService(String url, String content, Class<T> returnType, String... headers) {
        try{
            HttpPost post = new HttpPost(url);
            HttpParams params = new BasicHttpParams();
            params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
            params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            post.setParams(params);
            StringEntity body = new StringEntity(content, "utf-8");
            body.setContentType("Content-Type: application/json;charset=utf-8");
            post.setEntity(body);
            post.setHeader("Content-Type", "application/json;charset=utf-8");
            return execute(post, returnType, headers);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return null;
    }

    public static <T> T execute(HttpUriRequest req, Class<T> returnType, String... headers) {

        try {
            HttpResponse jres = httpClient.execute(req);
            HttpEntity ent = jres.getEntity();
            String content = ent != null ? EntityUtils.toString(jres.getEntity(), "UTF-8") : null;
            if (jres.getStatusLine().getStatusCode() >= 200
                    && jres.getStatusLine().getStatusCode() < 300) {
                if(returnType==String.class){
                    return (T)content;
                }
                return JSON.parseObject(content, returnType);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        return null;
    }

    public static <T> T get(String url, Class<T> returnType, String... headers) {
        HttpGet get = new HttpGet(url);
        return execute(get, returnType, headers);
    }
}
