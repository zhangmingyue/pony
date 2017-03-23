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
     * @param productTypeQueryBean
     * @return List<Product>
     */
    public List<Product> getProductByProductTypeId(ProductTypeQueryBean productTypeQueryBean);
    /**
     * 根据产品id获取三级类目
     *
     * @param productId
     * @return List<ProductType>
     */
    public List<ProductType> getProductTypeByProductId(@Param("productId")Integer productId);
    /**
     * 根据产品id获取三级类目
     *
     * @param productTypeList
     * @return List<Product>
     */
    public List<Product> getProductListBySecondProductTypeId(@Param("productTypeList")List<ProductType> productTypeList,@Param("productId")Integer productId);
}
