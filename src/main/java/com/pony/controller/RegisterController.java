package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.TestEntry;
import com.pony.domain.User;
import com.pony.enumeration.SMSCode;
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

//        smsUtil.sendSMS("17600805471", "乔译的测试签名", "SMS_47400198", "000000");
        List<TestEntry> service = testService.getAllTest();
        JSONObject test = new JSONObject();
        test.put("qiaoyi", "qiaoyi");
        test.put("test", service);

        return test;
    }

    /**
     * 用于用户第一次注册使用
     * 参数: phone用户手机号 token:用户token
     * _______________________________________________________________________________
     * code错误码:
     * 0:手机号是空 1:token是空 2:手机号不合乎规则 3:手机号已经注册过 4.短信发送失败 5.数据库插入错误
     * code成功码:10
     *
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String token = request.getParameter("token");

        if (Strings.isNullOrEmpty(phone)) {
            return returnDate(-1, SMSCode.PHONE_NULL, phone);
        }
        if (Strings.isNullOrEmpty(token)) {
            return returnDate(-1, SMSCode.TOKEN_NULL, phone);
        }
        if (!numberCheckerUtil.phoneNumberChecker(phone)) {
            return returnDate(-1, SMSCode.INVALID_PHONE, phone);
        }
        if (userService.checkPhoneExist(phone)) {
            return returnDate(-1, SMSCode.PHONE_REGISTERED, phone);
        }

        //生成6位验证码
        int checker = numberCheckerUtil.getChecker();
        if (smsUtil.sendSMS(phone, "乔译测试签名", "SMS_47400198", String.valueOf(checker)) == null) {
            return returnDate(-1, SMSCode.SEND_SMS_FAIL, phone);
        }
        User user = new User();
        user.setPhone(phone);

        Date date = new java.sql.Date(System.currentTimeMillis());
        user.setRegisterTime(date);
        user.setLastTime(date);

        if (userService.insert(user) < 0) {
            return returnDate(-1, SMSCode.INSERT_DATABASE_FAIL, phone);
        }

        return returnDate(checker, SMSCode.REGISRER_SUCC, phone);
    }


    @RequestMapping(value = "/forget_password", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject forgetPassWord(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        phone = "17600805471";
        password = "9999999";

        if (Strings.isNullOrEmpty(phone)) {
            return returnDate(-1, SMSCode.PHONE_NULL, phone);
        }

        if (Strings.isNullOrEmpty(password)) {
            return returnDate(-1, SMSCode.PASSWORD_NULL, phone);
        }
        if (!numberCheckerUtil.phoneNumberChecker(phone)) {
            return returnDate(-1, SMSCode.INVALID_PHONE, phone);
        }

        int checker = numberCheckerUtil.getChecker();
        if (smsUtil.sendSMS(phone, "乔译测试签名", "SMS_47400198", String.valueOf(checker)) == null) {
            return returnDate(-1, SMSCode.SEND_SMS_FAIL, phone);
        }
        if (!userService.updatePasswordByPhone(password, phone)) {
            return returnDate(-1, SMSCode.PHONE_REGISTERED, phone);
        }

        return returnDate(checker, SMSCode.REGISRER_SUCC, phone);
    }

    private JSONObject returnDate(int checker, int code, String phone) {
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();

        data.put("checker", checker);
        data.put("code", code);
        data.put("phone", phone);
        result.put("data", data);
        return result;
    }
}
