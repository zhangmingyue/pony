package com.pony.domain;

/**
 * Created by Administrator on 2017/4/4 0004.
 * 自提柜
 */
public class SelfLiftingCabinet {

    private int id;
    //自提柜编号
    private String cabinetNumber;
    //分库ID
    private int warehouseId;
    //分库
    private Warehouse warehouse;
    //小区如花园小区
    private ResidentialArea residentialArea;
    //地区如海淀区
    private District district;
    //备货基数
    private int stockingBase;

    //setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public ResidentialArea getResidentialArea() {
        return residentialArea;
    }

    public void setResidentialArea(ResidentialArea residentialArea) {
        this.residentialArea = residentialArea;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getStockingBase() {
        return stockingBase;
    }

    public void setStockingBase(int stockingBase) {
        this.stockingBase = stockingBase;
    }
}
