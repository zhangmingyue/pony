package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.queryBean.ProductTypeQueryBean;
import com.pony.dao.ProductForMobileDAO;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.dao.ProductTypeForMobileDAO;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;
import com.pony.productManage.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Service
public class ProductForMobileServiceImpl implements ProductForMobileService{

    @Autowired
    private ProductTypeForMobileDAO productTypeForMobileDAO;
    @Autowired
    private ProductForMobileDAO productForMobileDAO;

    @Override
    public List<Product> getProductList(ProductQueryBean productQueryBean){
        List<Product> productList = productForMobileDAO.getProductList(productQueryBean);
//        Double price;
//        ProductPrice productPrice;
//        for(Product product:productList){
//            productPrice = productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime());
//            if(productPrice == null){
//                price = 0.0;
//            }else{
//                price = productPrice.getPrice();
//            }
//            product.setOriginalPrice(price);
//        }
        return productList;
    }


    @Override
    public Product getProductById(ProductQueryBean productQueryBean){

        Product product = productForMobileDAO.getProductById(productQueryBean);
        product.setOriginalPrice(productForMobileDAO.getProductPriceByProductId(productQueryBean.getProductId(),getCurrentTime()).getPrice());
        return product;
    }
    /**
     * 根据id获取商品详细信息与商品图片
     *
     * @param productQueryBean
     * @return List<Product>
     */
    @Override
    public Product getProductAndProductPictureById(ProductQueryBean productQueryBean) {

        Product product = productForMobileDAO.getProductById(productQueryBean);
        product.setProductPictures(productForMobileDAO.getProductPictureByProductId(productQueryBean.getProductId()));
        ProductPrice productPrice = productForMobileDAO.getProductPriceByProductId(productQueryBean.getProductId(),getCurrentTime());
        if(productPrice!=null) {
            product.setOriginalPrice(productPrice.getPrice());
        }else{
            product.setOriginalPrice(0);
        }
        return product;

    }

    /**
     * 根据产品id获取推荐产品
     *
     * @param productQueryBean
     * @return String
     */
    public List<Product> getRecommendProductByProductId(ProductQueryBean productQueryBean){
        //该产品三级类目列表
        List<ProductType> productTypeThird = productTypeForMobileDAO.getProductTypeByProductId(productQueryBean.getProductId());
//        ProductTypeQueryBean productTypeQueryBean = new ProductTypeQueryBean();
//        productTypeQueryBean.setParentId(productType.getParentId());
        List<Product> productList =productTypeForMobileDAO.getProductListBySecondProductTypeId(productTypeThird,productQueryBean.getProductId());
//        List<Product> productList = new ArrayList<Product>();

//        List<ProductType> productTypeList = productTypeForMobileDAO.getChildProductTypeListByParentProductTypeId(productTypeQueryBean);

//        for(ProductType pt:productTypeList) {
//            productTypeQueryBean = new ProductTypeQueryBean();
//            productTypeQueryBean.setProductTypeId(pt.getId());
//            productList.addAll(productTypeForMobileDAO.getProductByProductTypeId(productTypeQueryBean));
//        }
        return productList;

    }
    /**
     * 根据promotionType获取首页促销
     *
     * @param promotionType
     * @return Product
     */
    public Product getPromotiononHomePage(Integer promotionType){
        Product promotion = productForMobileDAO.getPromotiononHomePage(promotionType);
        ProductPrice productPrice = productForMobileDAO.getProductPriceByProductId(promotion.getId(),getCurrentTime());
        if(productPrice!=null) {
            promotion.setOriginalPrice(productPrice.getPrice());
        }else{
            promotion.setOriginalPrice(0);
        }
        return promotion;
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        return currentTime;
    }

}
