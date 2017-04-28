package com.pony.dao;

import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ChildOrderProduct;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * getShoppingCartEntryById
 */
public interface ChildOrderForMobileDAO {



    /**
     * 添加子订单
     *
     * @param childOrder
     * @return int
     */
    public int addChildOrder(ChildOrder childOrder);
    /**
     * 修改子订单
     *
     * @param childOrder
     * @return int
     */
    public int updateChildOrder(ChildOrder childOrder);

    /**
     * 删除子订单
     *
     * @param childOrderId
     * @return int
     */
    public int deleteChildOrderById(@Param("childOrderId") Integer childOrderId);
    /**
     * 修改子订单状态
     *
     * @param state
     * @return int
     */
    public int updateChildOrderState(@Param("childOrderId") Integer childOrderId,@Param("state") Integer state);
    /**
     * 根据母单ID修改子订单状态
     *
     * @param state
     * @return int
     */
    public int updateChildOrderStateByProductOrderId(@Param("productOrderId") Integer productOrderId,@Param("state") Integer state);

    /**
     * 根据查询条件获取订单列表
     *
     * @param childOrderQueryBean
     * @return List<ChildOrder>
     */
    public List<ChildOrder> getChildOrderListByQueryBean(ChildOrderQueryBean childOrderQueryBean);

    /**
     * 根据子单ID获取子订单
     *
     * @param childOrderId
     * @return ChildOrder
     */
    public ChildOrder getChildOrderById(@Param("childOrderId") Integer childOrderId);

    /**
     * 根据子订单ID修改柜门密码（存放于子单内）密码需要为String类型（如0102。。。int变为102.。）
     */

    public int setPasswordByChildOrderId(@Param("productOrderId")Integer productOrderId ,@Param("password")String password);

    /**
     * 批量设置子订单过期
     *
     * @param
     * @return int[]
     */
    public int batchSetChildOrderExpired(@Param("productOrderIds") int[] productOrderIds);
    /**
     * 批量获取过期子订单ID
     *
     * @param
     * @return int[]
     */
    public int[] batchGetExpiredChildOrderId(@Param("productOrderIds") int[] productOrderIds);

}
