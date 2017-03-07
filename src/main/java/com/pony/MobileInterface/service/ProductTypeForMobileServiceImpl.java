package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductTypeQueryBean;
import com.pony.dao.ProductForMobileDAO;
import com.pony.dao.ProductTypeForMobileDAO;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPrice;
import com.pony.productManage.entity.ProductType;
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
public class ProductTypeForMobileServiceImpl implements ProductTypeForMobileService{

    @Autowired
    private ProductTypeForMobileDAO productTypeForMobileDAO;
    @Autowired
    private ProductForMobileDAO productForMobileDAO;


    /**
     * 获取一级类目链表
     *
     * @return List<Product>
     */
    public List<ProductType> getFirstProductTypeList(){
        return productTypeForMobileDAO.getFirstProductTypeList();
    }
    /**
     * 根据一集级目ID获取二级类目链表及三级类目
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getSecondAndThirdProductTypeListByFirstProductTypeId(ProductTypeQueryBean productTypeQueryBean){
        List<ProductType> productTypeList = productTypeForMobileDAO.getChildProductTypeListByParentProductTypeId(productTypeQueryBean);
        List<ProductType> thirdProductTypeList;
        ProductTypeQueryBean ptqb;
        for(ProductType productType:productTypeList){
            ptqb = new ProductTypeQueryBean();
            ptqb.setParentId(productType.getId());
            thirdProductTypeList = productTypeForMobileDAO.getChildProductTypeListByParentProductTypeId(ptqb);
            productType.setProductTypeList(thirdProductTypeList);
        }
        return productTypeList;
    }
    /**
     * 根据二级类目ID获取三级类目链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getThirdProductTypeListBySecondProductTypeId(ProductTypeQueryBean productTypeQueryBean) {
        return productTypeForMobileDAO.getChildProductTypeListByParentProductTypeId(productTypeQueryBean);
    }

    /**
     * 根据类目ID获取商品链表
     *
     * @param productTypeQueryBean
     * @return List<Product>
     */
    public List<Product> getProductByProductTypeId(ProductTypeQueryBean productTypeQueryBean) {
        List<Product> productList = productTypeForMobileDAO.getProductByProductTypeId(productTypeQueryBean);
        for(Product product: productList){
            ProductPrice productPrice = productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime());
            double price;
            if(productPrice==null){
                price = 0.0;
            }else{
                price = productPrice.getPrice();
            }
            product.setOriginalPrice(price);
        }
        return productList;
    }
    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        return currentTime;
    }

}
