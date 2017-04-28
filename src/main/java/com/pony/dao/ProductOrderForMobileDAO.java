package com.pony.dao;

import com.pony.MobileInterface.entity.ProductOrder;
import com.pony.MobileInterface.entity.queryBean.ProductOrderQueryBean;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductOrderForMobileDAO {



    /**
     * 添加订单
     *
     * @param productOrder
     * @return Product
     */
    public int addProductOrder(ProductOrder productOrder);

    /**
     * 根据订单id获取订单信息
     *
     * @param productOrderId
     * @return ProductOrder
     */
    public ProductOrder getProductOrderByOrderId(@Param("productOrderId") Integer productOrderId);

    /**
     * 根据查询条件获取订单列表
     *
     * @param productOrderQueryBean
     * @return List<ProductOrder>
     */
    public List<ProductOrder> getProductOrderListByQueryBean(ProductOrderQueryBean productOrderQueryBean);

    /**
     * 删除订单
     *
     * @param productOrderId
     * @return int
     */
    public int deleteProductOrderByProductOrderId(@Param("productOrderId") Integer productOrderId);

    /**
     * 根据订单ID更改订单状态
     *
     * @param productOrderId
     * @return int
     */
    public int updateProductOrderState(@Param("productOrderId") Integer productOrderId,@Param("state") Integer state);
    /**
     * 获取过期订单列表
     *
     * @param
     * @return int[]
     */
    public int[] getExpiredProductOrderList();

    /**
     * 批量设置订单过期
     *
     * @param
     * @return int[]
     */
    public int batchSetProductOrderExpired(@Param("productOrderIds") int[] productOrderIds);

}
