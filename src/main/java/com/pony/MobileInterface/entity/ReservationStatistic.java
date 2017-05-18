package com.pony.MobileInterface.entity;

import java.util.Date;

/**
 * 预约数据统计
 * Created by Administrator on 2017/5/17 0017.
 */
public class ReservationStatistic {

    private int id;
    //预约类型ID
    private int reservationId;
    //产品名称
    private String productName;
    //产品编码
    private String productNumber;
    //产品单位
    private String unit;
    //产品ID
    private int productId;
    //预约购买数量
    private int reservationNumber;
    //提货日期
    private Date deliveryDate;

    //setter and getter


    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
