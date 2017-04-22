package com.pony.MobileInterface.util;

import com.pony.productManage.entity.Product;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class ProductUtil {

    public static double getProductNowPrice(Product product){
        Date now = new Date();
        Date promotionBeginTime = product.getPromotionBeginTime();
        Date promotionEndTime = product.getPromotionEndTime();
        //
        if(now.after(promotionBeginTime)&&now.before(promotionEndTime)){
            return product.getPromotionPrice();
        }else{
            return product.getOriginalPrice();
        }
    }

}
