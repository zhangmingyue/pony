package com.pony.domain;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class Container {

    private int id;
    //货柜编号
    private String containerNumber;
    //自提柜类型
    private int selfLiftingCabinetId;
    //货柜类型ID
    private int containerTypeId;
    //货柜状态
    private int state;

    //setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
