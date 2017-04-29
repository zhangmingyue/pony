package com.pony.MobileInterface.entity;


import com.pony.domain.AddressEntity;
import com.pony.domain.Container;
import com.pony.domain.SelfLiftingCabinet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private int reservationType;
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
    //地址
    private AddressEntity addressEntity;
    //自提柜ID
    private int selfLiftingCabinetId;
    //自提柜
    private SelfLiftingCabinet selfLiftingCabinet;
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
    //状态:0为正常，1为过期，2为删除
    private int state;
    //购买数量
    private int productQuantity;
    //总价
    private double cost;

    //setter and getter


    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public SelfLiftingCabinet getSelfLiftingCabinet() {
        return selfLiftingCabinet;
    }

    public void setSelfLiftingCabinet(SelfLiftingCabinet selfLiftingCabinet) {
        this.selfLiftingCabinet = selfLiftingCabinet;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

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

    public int getReservationType() {
        return reservationType;
    }

    public void setReservationType(int reservationType) {
        this.reservationType = reservationType;
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

    public String getDeliveryDate() {

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  //M一定要大写！！！！
        return format1.format(deliveryDate);

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
