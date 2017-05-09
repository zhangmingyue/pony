package com.pony.MobileInterface.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pony.MobileInterface.entity.Advertisement;
import com.pony.MobileInterface.entity.AdvertisementOrSpecial;
import com.pony.MobileInterface.entity.Special;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.service.ProductForMobileService;
import com.pony.MobileInterface.service.SpecialAndAdvertisementService;
import com.pony.productManage.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 * 移动端获取数据接口
 */
@RestController
@RequestMapping("/SpecialAndAdvertisement")
public class SpecialAndAdvertisementController {

    private static final Logger log = LoggerFactory.getLogger(SpecialAndAdvertisementController.class);
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();


    @Autowired
    private SpecialAndAdvertisementService specialAndAdvertisementService;


    /**
     * 获取首页最上端广告
     *
     * @param currentTime
     * @return List<Product>
     */
    @RequestMapping(value = "/getTopAdvertisement", method = RequestMethod.GET)
    public String getTopAdvertisement(){

        Advertisement advertisement = specialAndAdvertisementService.getTopAdvertisement();
        return gson.toJson(advertisement);

    }

    /**
     * 获取专题或广告列表
     *
     *
     * @return List<Product>
     */
    @RequestMapping(value = "/getAdvertisementOrSpecialList", method = RequestMethod.GET)
    public String getAdvertisementOrSpecialList(){

        List<AdvertisementOrSpecial> advertisementOrSpecialList = specialAndAdvertisementService.getAdvertisementOrSpecialList();
        return gson.toJson(advertisementOrSpecialList);

    }


    /**
     * 按专题ID获取专题
     *
     * @param specialId
     * @return Special
     */
    @RequestMapping(value = "/getSpecialBySpecialId", method = RequestMethod.GET)
    public String getSpecialBySpecialId(Integer specialId){

        Special special = specialAndAdvertisementService.getSpecialBySpecialId(specialId);
        return gson.toJson(special);

    }


}
