package com.pony.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/12
 */
public class AddressEntity {
    private int id;
    private String phone;
    private String name;
    private int district;
    private int residentialArea;
    private int selfLiftingCabinet;
    private int warehouseId;
    private Date dt;
    private int  defaultAddress;
    private String userName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getResidentialArea() {
        return residentialArea;
    }

    public void setResidentialArea(int residentialArea) {
        this.residentialArea = residentialArea;
    }

    public int getSelfLiftingCabinet() {
        return selfLiftingCabinet;
    }

    public void setSelfLiftingCabinet(int selfLiftingCabinet) {
        this.selfLiftingCabinet = selfLiftingCabinet;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(int defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", district=" + district +
                ", residentialArea=" + residentialArea +
                ", selfLiftingCabinet=" + selfLiftingCabinet +
                ", warehouseId=" + warehouseId +
                ", dt=" + dt +
                ", defaultAddress=" + defaultAddress +
                ", userName='" + userName + '\'' +
                '}';
    }
}
