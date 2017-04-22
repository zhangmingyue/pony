package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ProductOrder;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductOrderQueryBean;


import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ProductOrderForMobileService {

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
    public ProductOrder getProductOrderByOrderId(Integer productOrderId);
    /**
     * 根据查询条件获取订单列表
     *
     * @param productOrderQueryBean
     * @return List<ProductOrder>
     */
    public List<ProductOrder> getProductOrderListByQueryBean(ProductOrderQueryBean productOrderQueryBean);
    /**
     * 根据查询条件获取各种状态子订单列表
     *
     * @param childOrderQueryBean
     * @return List<ChildOrder>
     */
    public List<ChildOrder> getChildOrderByQueryBean(ChildOrderQueryBean childOrderQueryBean);
    /**
     * 删除过期订单（不是真的删除）
     *
     * @param
     * @return List<ChildOrder>
     */
    public int deleteExpiredProductOrder();
}
