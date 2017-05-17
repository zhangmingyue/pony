package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.User;
import com.pony.enumeration.SMSCode;
import com.pony.service.Impl.LocationService;
import com.pony.service.UserService;
import com.pony.util.Base64Util;
import com.pony.util.FormatUtil;
import com.pony.util.NumberCheckerUtil;
import com.pony.util.SMSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    private final static String SIGNNAME = "小马自提";
    private final static String REGISTER_TEMPLATE_CODE = "SMS_47470165";
    private final static String PASSWORD_TEMPLATE_CODE = "SMS_47470163";

    @Autowired
    private NumberCheckerUtil numberCheckerUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private LocationService locationService;
    @Autowired
    private FormatUtil formatUtil;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        String test = Base64Util.getBase64("17600805471");
        String result = Base64Util.getFromBase64(test);
        log.info("test={}", test);
        log.info("result={}", result);

//        smsUtil.sendSMS("17600805471", SIGNNAME, PASSWORD_TEMPLATE_CODE, String.valueOf(123456));
//        String longitude = "39.983424";
//        String latitude = "116.322987";
//        JSONObject result = locationService.getOriginPositionByLongtiudeAndLatitude("", "");
//        JSONObject result = locationService.getPois(longitude, latitude);
//       smsUtil.sendSMS("17600805471", "乔译的测试签名", "SMS_47400198", "000000");
//        List<TestEntry> service = testService.getAllTest();
//        JSONObject test = new JSONObject();
//        test.put("qiaoyi", "qiaoyi");
//        test.put("test", service);
//        test.put("locate",result);

//        return result;
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
//        String token = request.getParameter("token");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String pt = request.getParameter("pt");
        String dt = request.getParameter("dt");

        if (Strings.isNullOrEmpty(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.PHONE_NULL, phone);
        }
//        if (Strings.isNullOrEmpty(token)) {
//            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.TOKEN_NULL, phone);
//        }
        if (!numberCheckerUtil.phoneNumberChecker(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.INVALID_PHONE, phone);
        }
        if (userService.checkPhoneExist(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.PHONE_REGISTERED, phone);
        }

        //生成6位验证码
        int checker = numberCheckerUtil.getChecker();
        if (smsUtil.sendSMS(phone, SIGNNAME, REGISTER_TEMPLATE_CODE, String.valueOf(checker)) == null) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.SEND_SMS_FAIL, phone);
        }
        User user = new User();
        user.setPhone(phone);
        if (!Strings.isNullOrEmpty(pt)) {
            user.setPt(Integer.parseInt(pt));
        }
        if (!Strings.isNullOrEmpty(dt)) {
            user.setDt(dt);
        }

        Date date = new java.sql.Date(System.currentTimeMillis());
        user.setRegisterTime(date);
        user.setLastTime(date);
        user.setLongitude(longitude);
        user.setLatitude(latitude);

        if (userService.insert(user) < 0) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.INSERT_DATABASE_FAIL, phone);
        }

        return formatUtil.returnCheckerCodeAndPhone(checker, SMSCode.REGISRER_SUCC, phone);
    }

    /**
     * 忘记密码获得验证码
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/forget_password_get_checker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject forgetPassWord(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");

        if (Strings.isNullOrEmpty(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.PHONE_NULL, phone);
        }

        if (!numberCheckerUtil.phoneNumberChecker(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.INVALID_PHONE, phone);
        }

        if (!userService.checkPhoneExist(phone)) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.PHONE_IS_NOT_IN_DATABSASE, phone);
        }

        int checker = numberCheckerUtil.getChecker();
        if (smsUtil.sendSMS(phone, SIGNNAME, PASSWORD_TEMPLATE_CODE, String.valueOf(checker)) == null) {
            return formatUtil.returnCheckerCodeAndPhone(-1, SMSCode.SEND_SMS_FAIL, phone);
        }

        return formatUtil.returnCheckerCodeAndPhone(checker, SMSCode.REGISRER_SUCC, phone);
    }

    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePassword(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        if (Strings.isNullOrEmpty(phone)) {
            return formatUtil.returnCodeAndPhone(SMSCode.PHONE_NULL, phone);
        }

        if (Strings.isNullOrEmpty(password)) {
            return formatUtil.returnCodeAndPhone(SMSCode.PASSWORD_NULL, phone);
        }

        if (!userService.updatePasswordByPhone(Base64Util.getFromBase64(password), phone)) {
            return formatUtil.returnCodeAndPhone(SMSCode.INSERT_DATABASE_FAIL, phone);
        }
        return formatUtil.returnCodeAndPhone(SMSCode.REGISRER_SUCC, phone);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        if (Strings.isNullOrEmpty(phone)) {
            return formatUtil.returnCodeAndPhone(SMSCode.PHONE_NULL, phone);
        }

        if (Strings.isNullOrEmpty(password)) {
            return formatUtil.returnCodeAndPhone(SMSCode.PASSWORD_NULL, phone);
        }

        if (userService.checkPhoneAndPassword(phone, Base64Util.getFromBase64(password))) {
            return formatUtil.returnCodeAndPhone(SMSCode.REGISRER_SUCC, phone);
        }
        return formatUtil.returnCodeAndPhone(SMSCode.PASSWORD_WRONG, phone);
    }

    @RequestMapping(value = "get_userId_by_phone", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getPois(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String phone = request.getParameter("phone");
        if (Strings.isNullOrEmpty(phone)) {
            result.put("code", 0);
            return result;
        }
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            int userId = user.getId();
            result.put("result", true);
            result.put("data", userId);
            return result;
        }

        result.put("code", 1);
        return result;
    }
}
