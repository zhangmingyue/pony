package com.pony.domain;

/**
 * Created by Administrator on 2017/4/4 0004.
 */
public class Address {

    private int id;
    //地址名称如女友家
    private String addressName;
    //所属用户
    private User user;
    //地区如海淀区
    private District district;
    //小区如花园小区
    private ResidentialArea residentialArea;
    //供应仓库
    private Warehouse warehouse;
    //自提柜
    private SelfLiftingCabinet selfLiftingCabinet;


    // setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public ResidentialArea getResidentialArea() {
        return residentialArea;
    }

    public void setResidentialArea(ResidentialArea residentialArea) {
        this.residentialArea = residentialArea;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public SelfLiftingCabinet getSelfLiftingCabinet() {
        return selfLiftingCabinet;
    }

    public void setSelfLiftingCabinet(SelfLiftingCabinet selfLiftingCabinet) {
        this.selfLiftingCabinet = selfLiftingCabinet;
    }
}
