package com.pony.MobileInterface.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.service.ProductForMobileService;
import com.pony.domain.User;
import com.pony.enumeration.SMSCode;
import com.pony.productManage.entity.Product;
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
import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 * 移动端获取数据接口
 */
@RestController
@RequestMapping("/product")
public class ProductForMobileController {

    private static final Logger log = LoggerFactory.getLogger(ProductForMobileController.class);
    private Gson gson = new Gson();


    @Autowired
    private ProductForMobileService productForMobileService;

    /**
     * 根据产品id获取产品信息但不包括产品展示图片
     */
    @RequestMapping(value = "/getProductById", method = RequestMethod.GET)
    public String getProductById(ProductQueryBean productQueryBean) {

//        System.out.println("productId:" + productId);
        System.out.println("productQueryBean:" + productQueryBean.getProductId());
//        ProductQueryBean productQueryBean = new ProductQueryBean();
//        productQueryBean.setProductId(new Integer(productId));
        Product product = productForMobileService.getProductById(productQueryBean);

        return  gson.toJson(product);

    }
    /**
     * 根据查询条件获取产品链表
     */
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    public String getProductList(ProductQueryBean productQueryBean) {
        List<Product> productList = productForMobileService.getProductList(productQueryBean);
        return gson.toJson(productList);
    }
    /**
     * 根据产品id获取产品信息但包括产品展示图片
     */
    @RequestMapping(value = "/getProductAndProductPictureById", method = RequestMethod.GET)
    public String getProductAndProductPictureById(ProductQueryBean productQueryBean) {

        Product product = productForMobileService.getProductAndProductPictureById(productQueryBean);

        return  gson.toJson(product);

    }
    /**
     * 根据产品id获取推荐产品
     */
    @RequestMapping(value = "/getRecommendProductByProductId", method = RequestMethod.GET)
    public String getRecommendProductByProductId(ProductQueryBean productQueryBean) {

        List<Product> productList = productForMobileService.getRecommendProductByProductId(productQueryBean);

        return  gson.toJson(productList);

    }
    /**
     * 根据promotionType获取首页促销
     *
     * @param promotionType
     * @return Product
     */
    @RequestMapping(value = "/getPromotionOnHomePage", method = RequestMethod.GET)
    public String getPromotionOnHomePage(Integer promotionType){
        Product promotion = productForMobileService.getPromotiononHomePage(promotionType);
        return  gson.toJson(promotion);
    }
    /**
     * 根据产品id与自提柜ID获取产品库存
     */
    //// TODO: 2017/3/28 0028 假数据未完成 
    @RequestMapping(value = "/getProductStock", method = RequestMethod.GET)
    public String getProductStock(ProductQueryBean productQueryBean,int selfLiftingCabinetId) {
        int stock = 50;
        return  gson.toJson(stock);

    }

}
