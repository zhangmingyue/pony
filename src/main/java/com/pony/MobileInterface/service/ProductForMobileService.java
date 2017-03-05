package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductForMobileService {

    /**
     * 根据查询条件获取商品链表
     *
     * @param productQueryBean
     * @return List<Product>
     */
    public List<Product> getProductList(ProductQueryBean productQueryBean);
    /**
     * 根据id获取商品详细信息
     *
     * @param productQueryBean
     * @return List<Product>
     */
    public Product getProductById(ProductQueryBean productQueryBean);
    /**
     * 根据id获取商品详细信息与商品图片
     *
     * @param productQueryBean
     * @return List<Product>
     */
    public Product getProductAndProductPictureById(ProductQueryBean productQueryBean);

}
