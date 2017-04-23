package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.User;
import com.pony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信用相关
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/3/26
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get_credit_by_user", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUserCredit(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        String phone = request.getParameter("phone");
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        result.put("result", false);

        if (Strings.isNullOrEmpty(idStr) && Strings.isNullOrEmpty(phone)) {
            data.put("code", 0);
            result.put("data", data);
            return result;
        }

        if (!Strings.isNullOrEmpty(idStr)) {
            User user = userService.getCreditByUserId(Integer.parseInt(idStr));
            data.put("user", user.getPhone());
            data.put("credit", user.getCredit());
            data.put("time", user.getLastTime());
            data.put("code", 200);
            result.put("result", true);
            result.put("data", data);
            return result;
        }

        if (!Strings.isNullOrEmpty(phone)) {
            User user = userService.getUserByPhone(phone);
            data.put("user", user.getPhone());
            data.put("credit", user.getCredit());
            data.put("time", user.getLastTime());
            data.put("code", 200);
            result.put("result", true);
            result.put("data", data);
            return result;
        }
        data.put("code", 1);
        result.put("data", data);
        return result;
    }
}
