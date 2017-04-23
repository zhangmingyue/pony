package com.pony.domain;

/**
 * Created by Administrator on 2017/4/4 0004.
 * 自提柜
 */
public class SelfLiftingCabinetToContainerType {

    private int id;
    //柜门数量
    private int containerQuantity;
    //自提柜ID
    private int selfLiftingCabinetId;
    //柜子类型
    private int containerTypeId;


    //setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContainerQuantity() {
        return containerQuantity;
    }

    public void setContainerQuantity(int containerQuantity) {
        this.containerQuantity = containerQuantity;
    }

    public int getSelfLiftingCabinetId() {
        return selfLiftingCabinetId;
    }

    public void setSelfLiftingCabinetId(int selfLiftingCabinetId) {
        this.selfLiftingCabinetId = selfLiftingCabinetId;
    }

    public int getContainerTypeId() {
        return containerTypeId;
    }

    public void setContainerTypeId(int containerTypeId) {
        this.containerTypeId = containerTypeId;
    }
}
