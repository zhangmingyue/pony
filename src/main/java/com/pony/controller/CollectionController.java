package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.service.ProductForMobileService;
import com.pony.domain.CollectionEntity;
import com.pony.productManage.entity.Product;
import com.pony.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/8
 */
@Controller
@RequestMapping(value = "/collection")
public class CollectionController {

    @Autowired
    CollectionService collectionService;
    @Autowired
    private ProductForMobileService productForMobileService;

    private Gson gson = new Gson();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject collectionAdd(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("product_id");
        String phone = request.getParameter("phone");

        JSONObject result = new JSONObject();
        result.put("result", false);
        result.put("phone", phone);

        if (Strings.isNullOrEmpty(productId) || Strings.isNullOrEmpty(phone)) {
            result.put("code", 0);
            return result;
        }

        int productIdInt = Integer.parseInt(productId);

        List<CollectionEntity> collectionEntities = collectionService.
                getListByPhoneAndProductId(phone, productIdInt);

        //如果用户收藏过则返回1,不储存
        if (collectionEntities != null && !collectionEntities.isEmpty()) {
            result.put("code", 1);
            return result;
        }

        Date time = new Date();
        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setPhone(phone);
        collectionEntity.setProductId(productIdInt);
        collectionEntity.setTime(time);

        if (collectionService.insert(collectionEntity) >= 1) {
            result.put("result", true);
            result.put("code", 200);

            return result;
        }

        result.put("code", 2);
        return result;
    }

    @RequestMapping(value = "/get_by_phone", method = RequestMethod.POST)
    @ResponseBody
    public String getCollection(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        List<CollectionEntity> collectionEntities = collectionService.getListByPhone(phone);

        ProductQueryBean productQueryBean = new ProductQueryBean();
        List<Product> productList = new ArrayList<>();
        for (CollectionEntity collectionEntity : collectionEntities) {
            int productId = collectionEntity.getProductId();
            if (productId > 0) {
                productQueryBean.setProductId(productId);
                Product product = productForMobileService.getProductAndProductPictureById(productQueryBean);
                productList.add(product);
            }
        }

        return gson.toJson(productList);
    }
}
