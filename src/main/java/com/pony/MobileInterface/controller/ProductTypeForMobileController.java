package com.pony.MobileInterface.controller;

import com.google.gson.Gson;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductTypeQueryBean;
import com.pony.MobileInterface.service.ProductForMobileService;
import com.pony.MobileInterface.service.ProductTypeForMobileService;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductType;
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
@RequestMapping("/productType")
public class ProductTypeForMobileController {

    private static final Logger log = LoggerFactory.getLogger(ProductTypeForMobileController.class);
    private Gson gson = new Gson();


    @Autowired
    private ProductTypeForMobileService productTypeForMobileService;


    /**
     * 获取一级类目链表
     *
     * @return List<Product>
     */
    @RequestMapping(value = "/getFirstProductTypeList", method = RequestMethod.GET)
    public String getFirstProductTypeList(){
        List<ProductType> productTypeList = productTypeForMobileService.getFirstProductTypeList();
        return gson.toJson(productTypeList);
    }
    /**
     * 根据一集级目ID获取二级类目链表及三级类目
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    @RequestMapping(value = "/getSecondAndThirdProductTypeListByFirstProductTypeId", method = RequestMethod.GET)
    public String getSecondAndThirdProductTypeListByFirstProductTypeId(ProductTypeQueryBean productTypeQueryBean){
        List<ProductType> productTypeList = productTypeForMobileService.getSecondAndThirdProductTypeListByFirstProductTypeId(productTypeQueryBean);
        return gson.toJson(productTypeList);
    }
    /**
     * 根据二级类目ID获取三级类目链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    @RequestMapping(value = "/getThirdProductTypeListBySecondProductTypeId", method = RequestMethod.GET)
    public String getThirdProductTypeListBySecondProductTypeId(ProductTypeQueryBean productTypeQueryBean){
        List<ProductType> productTypeList = productTypeForMobileService.getThirdProductTypeListBySecondProductTypeId(productTypeQueryBean);
        return gson.toJson(productTypeList);
    }

    /**
     * 根据类目ID获取商品链表
     *
     * @param productTypeQueryBean
     * @return List<Product>
     */
    @RequestMapping(value = "/getProductByProductTypeId", method = RequestMethod.GET)
    public String getProductByProductTypeId(ProductTypeQueryBean productTypeQueryBean){
        List<Product> productList = productTypeForMobileService.getProductByProductTypeId(productTypeQueryBean);
        return gson.toJson(productList);
    }

}
