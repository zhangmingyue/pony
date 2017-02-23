package com.pony.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.util.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/18
 */
@Service
public class LocationService {

    //用于测试ak=KaK3WhH5p6ali0IM5vi9sRlk(网上随便找的)
    private static final String AK = "KaK3WhH5p6ali0IM5vi9sRlk";
    private static final String GEOCODING_API = "http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=";

    public JSONObject getOriginPositionByLongtiudeAndLatitude(String longitude, String latitude) {

        if (Strings.isNullOrEmpty(longitude) || Strings.isNullOrEmpty(latitude)) {
            return null;
        }

        String api = GEOCODING_API + longitude + "," + latitude + "&output=json&pois=1&ak=" + AK;
        JSONObject data = new JSONObject();
        JSONObject result = new JSONObject();

        String receive = null;
        try {
            receive = HttpUtil.getService(api, String.class);
        } catch (Exception e) {
            result.put("status", 400);
            result.put("result", 0);
            data.put("data", result);
            return data;
        }
        try {
            receive = receive.substring(29, receive.length() - 1);
            result = JSONObject.parseObject(receive);
            data.put("data", result);
            return data;
        } catch (Exception e) {
            result.put("status", 400);
            result.put("result", 0);
            data.put("data", result);
            return data;
        }
    }

    /**
     * 由于百度map的接口返回的数据过于庞大不适于客户端之间的传输,开发根据经纬度获得此经纬度附近的10家poi
     *
     * @param longitude
     * @param latitude
     * @return
     */
    public JSONObject getPois(String longitude, String latitude) {
        JSONObject origin = getOriginPositionByLongtiudeAndLatitude(longitude, latitude);
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray tmpArray = new JSONArray();

        JSONObject poi = origin.getJSONObject("data");
        if (!poi.get("status").equals(400)) {
            JSONObject tmp = poi.getJSONObject("result");
            JSONArray array = tmp.getJSONArray("pois");

            for (int i = 0; i < array.size(); i++) {
                JSONObject pois = array.getJSONObject(i);
                tmpArray.add(pois.getString("name"));
            }
        }
        result.put("status", 200);
        result.put("pois", tmpArray);
        data.put("data", result);
        return data;
    }
}
