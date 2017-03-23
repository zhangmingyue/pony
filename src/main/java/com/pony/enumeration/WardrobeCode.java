package com.pony.enumeration;

/**
 * 柜子的返回结果
 * http://cs.uuuge.com/doc/xy14.html
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/25
 */
public class WardrobeCode {
    //操作成功
    public static final String OPERATION_SUCC = "000000";
    //系统内部异常
    public static final String SYSTEM_INNER_ERROR = "999999";
    //签名串错误
    public static final String SIGNATURE_ERROR = "000023";
    //apikey异常
    public static final String APIKEY_ERROR = "000024";
    //该格子不在使用状态，可能已被配送员取走
    public static final String UNABLE = "120017";
    //格号、订单号、手机号数据不一致
    public static final String DATA_INCONSISTENT = "000013";

}
