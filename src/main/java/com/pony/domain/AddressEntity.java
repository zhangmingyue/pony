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
    private int defaultAddress;
    private String userName;
    private String districtName;
    private String residentialAreaName;
    private String location;
    private int remove;
    private String cabinetNumber;
    private String receivePhone;

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

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getResidentialAreaName() {
        return residentialAreaName;
    }

    public void setResidentialAreaName(String residentialAreaName) {
        this.residentialAreaName = residentialAreaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRemove() {
        return remove;
    }

    public void setRemove(int remove) {
        this.remove = remove;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getRecieve_phone() {
        return receivePhone;
    }

    public void setRecieve_phone(String receive_phone) {
        this.receivePhone = receive_phone;
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
                ", districtName='" + districtName + '\'' +
                ", residentialAreaName='" + residentialAreaName + '\'' +
                ", location='" + location + '\'' +
                ", remove=" + remove +
                ", cabinetNumber='" + cabinetNumber + '\'' +
                ", receive_phone='" + receivePhone + '\'' +
                '}';
    }
}
