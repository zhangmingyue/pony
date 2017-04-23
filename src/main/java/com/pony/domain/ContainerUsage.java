package com.pony.domain;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class ContainerUsage {

    private int id;
    //货柜id
    private int containerId;
    //提货时间代码
    private int timeCoded;
    //创建时间
    private Date creatDate;
    //提货时间
    private Date deliveryDate;
    //子订单ID
    private int childOrderId;

    //setter and getter


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

    public int getTimeCoded() {
        return timeCoded;
    }

    public void setTimeCoded(int timeCoded) {
        this.timeCoded = timeCoded;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
