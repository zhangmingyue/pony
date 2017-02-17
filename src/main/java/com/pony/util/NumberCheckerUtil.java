package com.pony.util;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
@Component("numberCheckerUtil")
public class NumberCheckerUtil {

    private static final String pattern = "^((13[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
    private static final int MAX = 999999;
    private static final int MIN = 111111;

    /**
     * 手机号码检查
     *
     * @param phone
     * @return
     */
    public boolean phoneNumberChecker(String phone) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public int getChecker() {
        Random random = new Random();
        return random.nextInt(MAX) % (MAX - MIN + 1) + MIN;
    }
}
