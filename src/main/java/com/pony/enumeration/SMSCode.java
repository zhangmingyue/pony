package com.pony.enumeration;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/17
 */
public class SMSCode {
    //0:手机号是空
    public static final int PHONE_NULL = 0;
    //1:token是空
    public static final int TOKEN_NULL = 1;
    //2:手机号不合乎规则
    public static final int INVALID_PHONE = 2;
    //3:手机号已经注册过
    public static final int PHONE_REGISTERED = 3;
    //4.短信发送失败
    public static final int SEND_SMS_FAIL = 4;
    //5.数据库操作错误
    public static final int INSERT_DATABASE_FAIL = 5;
    //6.密码为空
    public static final int PASSWORD_NULL = 6;
    //7.手机号未在数据库中
    public static final int PHONE_IS_NOT_IN_DATABSASE = 7;
    //8.手机号与密码不匹配
    public static final int PASSWORD_WRONG = 8;
    //code成功码:200
    public static final int REGISRER_SUCC = 200;
}
