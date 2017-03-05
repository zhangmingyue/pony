package com.pony.dao;

import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductTypeQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;
import com.pony.productManage.entity.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductTypeForMobileDAO {


    /**
     * 获取一级类目链表
     *
     * @return List<Product>
     */
    public List<ProductType> getFirstProductTypeList();
    /**
     * 根据父类目ID获取子类目链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getChildProductTypeListByParentProductTypeId(ProductTypeQueryBean productTypeQueryBean);

    /**
     * 根据类目ID获取商品链表
     *
     * @param String
     * @return List<Product>
     */
    public List<Product> getProductByProductTypeId(ProductTypeQueryBean productTypeQueryBean);
}
