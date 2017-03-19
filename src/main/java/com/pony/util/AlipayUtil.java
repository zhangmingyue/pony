package com.pony.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/13
 */
public class AlipayUtil {

    public static final String GATEWAY_URL_ALIBABA = "https://openapi.alipaydev.com/gateway.do";
    public static final String APP_ID = "2017030906130605";
    public static final String FORMAT = "json";
    public static final String CHARSET = "UTF-8";
    public static final String SIGN_TYPE = "RSA2";

    private static AlipayClient alipayClient = null;

    public static AlipayClient getAlipayClient() throws AlipayApiException {
        //实例化客户端
        if (alipayClient == null) {
            synchronized (AlipayUtil.class) {
                if (null == alipayClient) {
                    alipayClient = new DefaultAlipayClient(GATEWAY_URL_ALIBABA, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                }
            }
        }
        return alipayClient;
    }
}
