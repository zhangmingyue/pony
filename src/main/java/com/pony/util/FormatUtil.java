package com.pony.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/18
 */
@Component
public class FormatUtil {

    public JSONObject returnCheckerCodeAndPhone(int checker, int code, String phone) {
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();

        data.put("checker", checker);
        data.put("code", code);
        data.put("phone", phone);
        result.put("data", data);
        return result;
    }


    public JSONObject returnCodeAndPhone(int code, String phone) {
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();

        data.put("code", code);
        data.put("phone", phone);
        result.put("data", data);
        return result;
    }
}
