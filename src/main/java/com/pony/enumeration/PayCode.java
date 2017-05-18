package com.pony.enumeration;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/15
 */
public class PayCode {

    /**
     * 1~10 都是客户端传参数问题
     */
    //手机号码为空
    public static int PHONE_NULL = 0;
    //订单号为空
    public static int MECNUM = 1;
    //钱不合法
    public static int CRASH_INVALID = 2;
    //订单问题
    public static int ORDERID=3;
    //查询钱数不符合
    public static int CHECK_MONEY=4;
}
