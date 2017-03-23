package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductTypeQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductType;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductTypeForMobileService {

    /**
     * 获取一级类目链表
     *
     * @return List<Product>
     */
    public List<ProductType> getFirstProductTypeList();
    /**
     * 根据一集级目ID获取二级类目链表及三级类目
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getSecondAndThirdProductTypeListByFirstProductTypeId(ProductTypeQueryBean productTypeQueryBean);
    /**
     * 根据二级类目ID获取三级类目链表
     *
     * @param productTypeQueryBean
     * @return List<ProductType>
     */
    public List<ProductType> getThirdProductTypeListBySecondProductTypeId(ProductTypeQueryBean productTypeQueryBean);

    /**
     * 根据类目ID获取商品链表
     *
     * @param productTypeQueryBean
     * @return List<Product>
     */
    public List<Product> getProductByProductTypeId(ProductTypeQueryBean productTypeQueryBean);

}
