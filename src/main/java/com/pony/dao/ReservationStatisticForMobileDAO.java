package com.pony.dao;

import com.pony.MobileInterface.entity.ReservationStatistic;
import com.pony.MobileInterface.entity.Stock;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 库存
 */
public interface ReservationStatisticForMobileDAO {


    /**
     * 根据产品ID与提货日期查询预约统计数据
     *
     * @param deliveryDate productId
     * @return int
     */
    public int getReservationStatisticIdByProductIdAndDeliveryDate(@Param("productId") String productId, @Param("deliveryDate") String deliveryDate);

    /**
     * 根据预约统计数据ID更新预约购买数量
     *
     * @param reservationNumber productId
     * @return int
     */
    public int updateReservationNumberById(@Param("reservationNumber") Integer reservationNumber, @Param("symbol") Integer symbol,@Param("reservationStatisticId") Integer reservationStatisticId);
    /**
     * 添加预约统计数据
     *
     * @param reservationStatistic
     * @return int
     */
    public int addReservationStatistic(ReservationStatistic reservationStatistic);


}
