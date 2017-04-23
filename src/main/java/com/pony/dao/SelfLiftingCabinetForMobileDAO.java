package com.pony.dao;


import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.domain.Container;
import com.pony.domain.ContainerUsage;
import com.pony.domain.SelfLiftingCabinet;
import com.pony.domain.SelfLiftingCabinetToContainerType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface SelfLiftingCabinetForMobileDAO {



    /**
     * 根据小区ID获取自提柜列表
     *
     * @param residentialAreaId
     * @return List<SelfLiftingCabinet>
     */
    public List<SelfLiftingCabinet> getSelfLiftingCabinetListByResidentialAreaId(@Param("residentialAreaId") Integer residentialAreaId);

    /**
     * 根据自提柜id获取自提柜详细信息
     *
     * @param selfLiftingCabinetId
     * @return SelfLiftingCabinet
     */
    public SelfLiftingCabinet getSelfLiftingCabinetBySelfLiftingCabinetId(@Param("selfLiftingCabinetId") Integer selfLiftingCabinetId);
    /**
     * 查询该时间点可用柜门类型及数量
     *
     * @param selfLiftingCabinetId
     * @return List<UsableContainerTypeAndNumber>
     */
    public List<UsableContainerTypeAndNumber> getUsableContainerTypeAndNumber(@Param("selfLiftingCabinetId") Integer selfLiftingCabinetId,
                                                                              @Param("team") int team,
                                                                              @Param("deliveryDate") String deliveryDate,
                                                                              @Param("timeCode") int timeCode);
    /**
     * 根据柜门类型ID查询自提柜该时间点该类型可用柜门链表
     *
     * @param selfLiftingCabinetId
     * @return List<Container>
     */
    public List<Container> getUsableContainerList(@Param("containerTypeId") Integer containerTypeId,
                                                  @Param("selfLiftingCabinetId") Integer selfLiftingCabinetId,
                                                  @Param("team") int team,
                                                  @Param("deliveryDate") String deliveryDate,
                                                  @Param("timeCode") int timeCode);
    /**
     * 占用柜门
     *
     * @param containerUsage
     * @return int
     */
    public int addContainerUsage(ContainerUsage containerUsage);

    /**
     * 释放柜门
     *
     * @param productOrderId
     * @return int
     */
    public int deleteContainerUsage(@Param("productOrderId") Integer productOrderId);

    /**
     * 查询该柜门是否被占用
     *
     * @param containerUsage
     * @return int
     */
    public int checkContainerUsage(ContainerUsage containerUsage);

    /**
     * 查询该柜门是否被占用
     *
     * @param containerId
     * @return Container
     */
    public Container getContainerById(@Param("containerId") Integer containerId);
    /**
     * 批量释放柜门
     *
     * @param childOrderIds
     * @return int
     */
    public int batchDeleteContainerUsage(@Param("childOrderIds") int[] childOrderIds);
}
