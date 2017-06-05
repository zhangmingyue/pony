package com.pony.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
public class RefundEntry {
    private int id;
    private String phone;
    private String orderId;
    private String reason;
    private String message;
    private String pic1;
    private String pic2;
    private String pic3;
    private String productId;
    private int number;
    private int status;
    private Date time;
    private String address;
    private String money;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return time;
    }

    public void setDate(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "RefundEntry{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", orderId='" + orderId + '\'' +
                ", reason='" + reason + '\'' +
                ", message='" + message + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", pic2='" + pic2 + '\'' +
                ", pic3='" + pic3 + '\'' +
                ", productId='" + productId + '\'' +
                ", number=" + number +
                ", status=" + status +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", money='" + money + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
