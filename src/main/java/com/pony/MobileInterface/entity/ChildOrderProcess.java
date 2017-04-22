package com.pony.MobileInterface.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/6 0006.
 * 子订单流程
 */
public class ChildOrderProcess {

    private int id;
    //流程节点ID
    private int processPointId;
    //流程节点名称
    private String processPointName;
    //子订单ID
    private int childOrderId;
    //创建时间
    private Date creatTime;

    //setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProcessPointId() {
        return processPointId;
    }

    public void setProcessPointId(int processPointId) {
        this.processPointId = processPointId;
    }

    public String getProcessPointName() {
        return processPointName;
    }

    public void setProcessPointName(String processPointName) {
        this.processPointName = processPointName;
    }

    public int getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(int childOrderId) {
        this.childOrderId = childOrderId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
