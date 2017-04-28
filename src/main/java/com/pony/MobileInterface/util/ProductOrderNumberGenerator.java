package com.pony.MobileInterface.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class ProductOrderNumberGenerator {


    public static String getProductOrderNumber(){

        DateFormat format1 = new SimpleDateFormat("ddHHmmss");  //M一定要大写！！！！
        String productOrderNumber = format1.format(new Date());
        productOrderNumber+= (int)((Math.random()*9+1)*100000);

        return productOrderNumber;
    }

//    public static void main(String [] args) {
//        System.out.println(getProductOrderNumber());
//    }
}
