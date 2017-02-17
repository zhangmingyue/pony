package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.TestEntry;
import com.pony.domain.User;
import com.pony.service.TestService;
import com.pony.service.UserService;
import com.pony.util.NumberCheckerUtil;
import com.pony.util.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Random;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private TestService testService;
    @Autowired
    private NumberCheckerUtil numberCheckerUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private SMSUtil smsUtil;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JSONObject test() {

        smsUtil.sendSMS("17600805471", "乔译的测试签名", "SMS_47400198", "000000");
        List<TestEntry> service = testService.getAllTest();
        JSONObject test = new JSONObject();
        test.put("qiaoyi", "qiaoyi");
        test.put("test", service);

        return test;
    }


    @RequestMapping(value = "/getChecker", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getChecker(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();

        if (Strings.isNullOrEmpty(phone)) {
            data.put("checker", -1);
            data.put("code", 0);
            result.put("data", data);
            return result;
        }

        if (!numberCheckerUtil.phoneNumberChecker(phone)) {
            data.put("checker", -1);
            data.put("code", 1);
            data.put("phone", phone);
            result.put("data", data);
            return result;
        }

        Random random = new Random();

        //生成6位验证码
        int checker = random.nextInt(999999) % (999999 - 111111 + 1) + 111111;
        smsUtil.sendSMS(phone, "乔译测试签名", "SMS_47400198", String.valueOf(checker));
        User user = new User();
        user.setPhone(phone);
        user.setCredit(checker);
        Date date = new java.sql.Date(System.currentTimeMillis());
        user.setRegisterTime(date);
        user.setLastTime(date);

        userService.insert(user);

        data.put("checker", checker);
        data.put("code", 2);
        data.put("phone", phone);
        result.put("data", data);
        return result;
    }
}
