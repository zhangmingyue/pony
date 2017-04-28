package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ProductOrder;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductOrderQueryBean;
import org.apache.ibatis.annotations.Param;


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
    /**
     * 根据子订单ID修改柜门密码（存放于子单内）密码需要为String类型（如0102。。。int变为102.。）
     */

    public int setPasswordByChildOrderId(Integer productOrderId , String password);
    /**
     * 修改子订单状态
     *
     * @param state
     * @return int
     */
    public int updateChildOrderState(Integer childOrderId,Integer state);
    /**
     * 根据订单ID更改订单状态为已付款
     *
     * @param productOrderId
     * @return int
     */
    public int updateProductOrderStateToPaid(Integer productOrderId);
    /**
     * 根据子订单ID获取子订单详细信息
     */
    public ChildOrder getChildOrderById(Integer childOrderId);
}
