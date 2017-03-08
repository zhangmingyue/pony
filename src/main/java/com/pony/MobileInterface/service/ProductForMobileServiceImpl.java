package com.pony.MobileInterface.service;

import com.pony.dao.ProductForMobileDAO;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Service
public class ProductForMobileServiceImpl implements ProductForMobileService{
    @Autowired
    private ProductForMobileDAO productForMobileDAO;
    @Override
    public List<Product> getProductList(ProductQueryBean productQueryBean){
        List<Product> productList = productForMobileDAO.getProductList(productQueryBean);
        Double price;
        ProductPrice productPrice;
        for(Product product:productList){
            productPrice = productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime());
            if(productPrice == null){
                price = 0.0;
            }else{
                price = productPrice.getPrice();
            }
            product.setOriginalPrice(price);
        }
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

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        return currentTime;
    }

}
