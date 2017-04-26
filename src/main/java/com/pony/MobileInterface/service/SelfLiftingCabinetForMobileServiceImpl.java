package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.dao.SelfLiftingCabinetForMobileDAO;
import com.pony.dao.TestDAO;
import com.pony.domain.Container;
import com.pony.domain.SelfLiftingCabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Service
public class SelfLiftingCabinetForMobileServiceImpl implements SelfLiftingCabinetForMobileService{
    @Autowired
    private SelfLiftingCabinetForMobileDAO selfLiftingCabinetForMobileDAO;

    /**
     * 根据小区ID获取自提柜列表
     *
     * @param residentialAreaId
     * @return List<SelfLiftingCabinet>
     */
    public List<SelfLiftingCabinet> getSelfLiftingCabinetListByResidentialAreaId(Integer residentialAreaId){
        return selfLiftingCabinetForMobileDAO.getSelfLiftingCabinetListByResidentialAreaId(residentialAreaId);
    }

    /**
     * 根据自提柜id获取自提柜详细信息
     *
     * @param selfLiftingCabinetId
     * @return SelfLiftingCabinet
     */
    public SelfLiftingCabinet getSelfLiftingCabinetBySelfLiftingCabinetId(Integer selfLiftingCabinetId){
        return selfLiftingCabinetForMobileDAO.getSelfLiftingCabinetBySelfLiftingCabinetId(selfLiftingCabinetId);
    }
    /**
     * 查询该时间点可用柜门类型及数量
     *
     * @param selfLiftingCabinetId
     * @return UsableContainerTypeAndNumber
     */
    public List<UsableContainerTypeAndNumber> getUsableContainerTypeAndNumber(Integer selfLiftingCabinetId, String deliveryDate, int timeCode){
        int team =0;
        if(timeCode%2 == 0){
            team = 1;
        }
        return selfLiftingCabinetForMobileDAO.getUsableContainerTypeAndNumber(selfLiftingCabinetId,team,deliveryDate,timeCode);
    }
    /**
     * 查询该时间点可用柜门类型、数量和具体链表
     *
     * @param selfLiftingCabinetId
     * @return UsableContainerTypeAndNumber
     */
    public List<UsableContainerTypeAndNumber> getUsableContainerTypeAndNumberAndList(Integer selfLiftingCabinetId, String deliveryDate, int timeCode){
        int team =0;
        if(timeCode%2 == 0){
            team = 1;
        }
        List<UsableContainerTypeAndNumber> usableContainerTypeAndNumber = selfLiftingCabinetForMobileDAO.getUsableContainerTypeAndNumber(selfLiftingCabinetId,team,deliveryDate,timeCode);
        List<Container> containerList;
        for(UsableContainerTypeAndNumber u:usableContainerTypeAndNumber){
            containerList = selfLiftingCabinetForMobileDAO.getUsableContainerList(u.getContainerTypeId(),selfLiftingCabinetId,team,deliveryDate,timeCode);
            for(Container c:containerList){
                u.getContainerStack().push(c);
            }
        }
        return usableContainerTypeAndNumber;
    }
}

