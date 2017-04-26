package com.pony.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class ContainerUsage {

    private int id;
    //柜门id
    private int containerId;
    //提货时间代码
    private int timeCode;
    //创建时间
    private Date creatDate;
    //提货时间
    private Date deliveryDate;
    //子订单ID
    private int childOrderId;
    //自提柜ID
    private int selfLiftingCabinetId;
    //setter and getter


    public int getSelfLiftingCabinetId() {
        return selfLiftingCabinetId;
    }

    public void setSelfLiftingCabinetId(int selfLiftingCabinetId) {
        this.selfLiftingCabinetId = selfLiftingCabinetId;
    }

    public int getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(int childOrderId) {
        this.childOrderId = childOrderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getDeliveryDate() {

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  //M一定要大写！！！！
        return format1.format(deliveryDate);

    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
