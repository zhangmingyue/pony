package com.pony.dao;

import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ChildOrderProduct;
import com.pony.MobileInterface.entity.Stock;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 库存
 */
public interface StockForMobileDAO {


    /**
     * 根据产品ID与仓库ID查询库存实体类
     *
     * @param warehouseId productId
     * @return int
     */
    public Stock getStockByWarehouseIdAndProductId(@Param("warehouseId") Integer warehouseId, @Param("productId") Integer productId);

    /**
     * 根据产品ID与仓库ID查询库存数量
     *
     * @param warehouseId productId
     * @return int
     */
    public int getInventoryByWarehouseIdAndProductId(@Param("warehouseId") Integer warehouseId,@Param("productId") Integer productId);
    /**
     * 根据产品ID与仓库ID修改库存数量
     *
     * @param subtractNumber
     * @return int
     */
    public int updateInventory(@Param("subtractNumber")int subtractNumber,@Param("warehouseId") Integer warehouseId,@Param("productId") Integer productId);

    /**
     * 根据库存ID修改库存数量 simble 0减库存 1加库存
     *
     * @param changeNumber
     * @return int
     */
    public int updateInventoryByStockId(@Param("stockId")Integer stockId,@Param("changeNumber") Integer changeNumber,@Param("simble") Integer simble);
    /**
     * 根据库存ID查询库存数量
     *
     * @param stockId
     * @return int
     */
    public int getInventoryByStockId(@Param("stockId")Integer stockId);

}
