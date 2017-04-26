package com.pony.MobileInterface.entity;

import com.pony.domain.AddressEntity;
import com.pony.domain.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/4 0004.
 * 订单
 */
public class ProductOrder {

    private int id;
    //订单编号
    private String productOrderNumber;
    //用户ID
    private int userId;
    //用户
    private User user;
    //地址ID
    private int addressId;
    //地址
    private AddressEntity addressEntity;
    //合计金额
    private double cost;
    //商品数量
    private int productQuantity;
    //创建时间
    private int createTime;
    //子单预约类型 0为现货 1为预约
    private int childOrderReservationType;
    //子订单列表
    private List<ChildOrder> childOrderList;
    //提货日期
    private Date deliveryDate;
    //时间代码
    private int timeCode;

    //setter and getter


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

    public void setProductOrderNumber(String productOrderNumber) {
        this.productOrderNumber = productOrderNumber;
    }

    public int getUserId() {
        return userId;
    }

    public int getChildOrderReservationType() {
        return childOrderReservationType;
    }

    public void setChildOrderReservationType(int childOrderReservationType) {
        this.childOrderReservationType = childOrderReservationType;
    }

    public List<ChildOrder> getChildOrderList() {
        return childOrderList;
    }

    public void setChildOrderList(List<ChildOrder> childOrderList) {
        this.childOrderList = childOrderList;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductOrderNumber() {
        return productOrderNumber;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
