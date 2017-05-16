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
    private Date update_time;
    private String outRequestNo;
    private String refundFee;
    private String status;

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

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
                ", update_time=" + update_time +
                ", outRequestNo='" + outRequestNo + '\'' +
                ", refundFee='" + refundFee + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
