package com.pony.MobileInterface.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class ProductOrderNumberGenerator {

    //todo
    public static String getProductOrderNumber(){

        DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");  //M一定要大写！！！！
        String productOrderNumber = format1.format(new Date());


        return productOrderNumber;
    }
    //todo
    public static String getChildOrderNumber(){
        return "";
    }
}
