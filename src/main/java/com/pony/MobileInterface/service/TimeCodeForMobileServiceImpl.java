package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.ProductTemp;
import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.dao.ProductForMobileDAO;
import com.pony.dao.ProductTypeForMobileDAO;
import com.pony.dao.SelfLiftingCabinetForMobileDAO;
import com.pony.productManage.entity.Product;
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
public class TimeCodeForMobileServiceImpl implements TimeCodeForMobileService{

    @Autowired
    private ProductTypeForMobileDAO productTypeForMobileDAO;
    @Autowired
    private ProductForMobileDAO productForMobileDAO;
    @Autowired
    private SelfLiftingCabinetForMobileDAO selfLiftingCabinetForMobileDAO;
    /**
     * 根据购物车获取产品临时链表
     *
     * @param shoppingCartIds
     * @return List<ProductTemp>
     */
    public List<ProductTemp> getProductTempList(String[] shoppingCartIds){
        //todo
        List<ProductTemp>  productTempList = new ArrayList<ProductTemp>();
        ProductTemp productTemp;
        Product product;
        ProductQueryBean productQueryBean = new ProductQueryBean();
        for(int i=0;i<10;i++){
            productTemp = new ProductTemp();
            productTemp.setProductHigh(10);
            productTemp.setProductLength(10);
            productTemp.setProductWidth(20);
            productTemp.setNumber(2);
            productTempList.add(productTemp);

        }
        return productTempList;
    }
    /**
     * 根据购物车获取产品临时链表包括产品信息
     *
     * @param shoppingCartIds
     * @return List<ProductTemp>
     */
    public List<ProductTemp> getProductTempListIncludeProduct(String[] shoppingCartIds){
        //todo
        List<ProductTemp>  productTempList = new ArrayList<ProductTemp>();
        ProductTemp productTemp;
        Product product;
        ProductQueryBean productQueryBean = new ProductQueryBean();
        for(int i=0;i<10;i++){
            productTemp = new ProductTemp();
            productTemp.setProductHigh(10);
            productTemp.setProductLength(10);
            productTemp.setProductWidth(20);
            productTemp.setNumber(2);
            productQueryBean.setProductId(productTemp.getProductId());
            product = productForMobileDAO.getProductById(productQueryBean);
            productTemp.setProduct(product);
            productTempList.add(productTemp);
        }
        return productTempList;
    }


}
