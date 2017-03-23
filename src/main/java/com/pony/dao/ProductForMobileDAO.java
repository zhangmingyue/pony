package com.pony.dao;

import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductForMobileDAO {


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
     * 根据产品id获取商品图片链表
     *
     * @param productId
     * @return List<ProductPicture>
     */
    public List<ProductPicture> getProductPictureByProductId(@Param("productId")Integer productId);
    /**
     * 根据产品id获取商品价格
     *
     * @param productId currentTime
     * @return ProductPrice
     */
    public ProductPrice getProductPriceByProductId(@Param("productId")Integer productId,@Param("currentTime")String currentTime);

}
