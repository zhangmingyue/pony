package com.pony.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/15
 */
public class PayEntity {
    private int id;
    private String phone;
    private int userId;
    private String outTradeNo;
    private String tradeNo;
    private String totalAmount;
    private Date time;
    private Date updateTime;
    private String outRequestNo;
    private String refundFee;
    private int status;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PayEntity{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", time=" + time +
                ", updateTime=" + updateTime +
                ", outRequestNo='" + outRequestNo + '\'' +
                ", refundFee='" + refundFee + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
