package com.pony.MobileInterface.entity;


import com.pony.domain.Container;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/4 0004.
 * 子单
 */
public class ChildOrder {

    private int id;
    //用户ID
    private int userId;
    //子单编号
    private String childOrderNumber;
    //子单类型1为现货单0为预约单
    private int childOrderType;
    //地址
    private String address;
    //创建时间
    private Date createTime;
    //提货日期
    private Date deliveryDate;
    //时间代码
    private int timeCode;
    //地址ID
    private int addressId;
    //自提柜ID
    private int selfLiftingCabinetId;
    //货柜ID
    private int containerId;
    //货柜
    private Container container;
    //密码
    private int password;
    //母单ID
    private int productOrderId;
    //产品列表
    private List<ChildOrderProduct> childOrderProductList;
    //setter and getter


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ChildOrderProduct> getChildOrderProductList() {
        return childOrderProductList;
    }

    public void setChildOrderProductList(List<ChildOrderProduct> childOrderProductList) {
        this.childOrderProductList = childOrderProductList;
    }

    public int getChildOrderType() {
        return childOrderType;
    }

    public void setChildOrderType(int childOrderType) {
        this.childOrderType = childOrderType;
    }

    public String getChildOrderNumber() {
        return childOrderNumber;
    }

    public void setChildOrderNumber(String childOrderNumber) {
        this.childOrderNumber = childOrderNumber;
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getSelfLiftingCabinetId() {
        return selfLiftingCabinetId;
    }

    public void setSelfLiftingCabinetId(int selfLiftingCabinetId) {
        this.selfLiftingCabinetId = selfLiftingCabinetId;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
