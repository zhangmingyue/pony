package com.pony.dao;

import com.pony.MobileInterface.entity.ChildOrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface ChildOrderProductForMobileDAO {



    /**
     * 添加子订单产品
     *
     * @param childOrderProduct
     * @return int
     */
    public int addChildOrderProduct(ChildOrderProduct childOrderProduct);



    /**
     * 根据子订单id获取子订单产品链表
     *
     * @param childOrderId
     * @return List<ChildOrderProduct>
     */
    public List<ChildOrderProduct> getChildOrderProductListByChildOrderId(@Param("childOrderId") Integer childOrderId);

    /**
     * 删除子订单产品
     *
     * @param childOrderProductId
     * @return int
     */
    public int deleteChildOrderProduct(@Param("childOrderProductId") Integer childOrderProductId);
    /**
     * 批量删除子订单产品
     *
     * @param
     * @return int[]
     */
    public int batchDeleteChildOrderProduct(@Param("childOrderIds") int[] childOrderIds);
    /**
     * 批量获取子订单产品
     *
     * @param
     * @return int[]
     */
    public List<ChildOrderProduct> batchGetChildOrderProduct(@Param("childOrderIds") int[] childOrderIds);
}
