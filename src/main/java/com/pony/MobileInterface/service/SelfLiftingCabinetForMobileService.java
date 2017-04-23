package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.domain.SelfLiftingCabinet;
import com.pony.productManage.entity.Product;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface SelfLiftingCabinetForMobileService {

    /**
     * 根据小区ID获取自提柜列表
     *
     * @param residentialAreaId
     * @return List<SelfLiftingCabinet>
     */
    public List<SelfLiftingCabinet> getSelfLiftingCabinetListByResidentialAreaId(Integer residentialAreaId);

    /**
     * 根据自提柜id获取自提柜详细信息
     *
     * @param selfLiftingCabinetId
     * @return SelfLiftingCabinet
     */
    public SelfLiftingCabinet getSelfLiftingCabinetBySelfLiftingCabinetId(Integer selfLiftingCabinetId);

    /**
     * 查询该时间点可用柜门类型及数量
     *
     * @param selfLiftingCabinetId
     * @return UsableContainerTypeAndNumber
     */
    public List<UsableContainerTypeAndNumber> getUsableContainerTypeAndNumber(Integer selfLiftingCabinetId, String deliveryDate, int timeCode);
    /**
     * 查询该时间点可用柜门类型、数量和具体链表
     *
     * @param selfLiftingCabinetId
     * @return UsableContainerTypeAndNumber
     */
    public List<UsableContainerTypeAndNumber> getUsableContainerTypeAndNumberAndList(Integer selfLiftingCabinetId, String deliveryDate, int timeCode);

    }
