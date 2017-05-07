package com.pony.domain;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public class SelfLiftingCabinetEntity {
    private int id;
    private String cabinetNumber;
    private int businessOutletId;
    private int warehouseId;
    private int stockingBase;
    private int districtId;
    private int residentialAreaId;
    private String location;
    private int isFresh;

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

    public int getBusinessOutletId() {
        return businessOutletId;
    }

    public void setBusinessOutletId(int businessOutletId) {
        this.businessOutletId = businessOutletId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getStockingBase() {
        return stockingBase;
    }

    public void setStockingBase(int stockingBase) {
        this.stockingBase = stockingBase;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getResidentialAreaId() {
        return residentialAreaId;
    }

    public void setResidentialAreaId(int residentialAreaId) {
        this.residentialAreaId = residentialAreaId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIsFresh() {
        return isFresh;
    }

    public void setIsFresh(int isFresh) {
        this.isFresh = isFresh;
    }

    @Override
    public String toString() {
        return "SelfLiftingCabinetEntity{" +
                "id=" + id +
                ", cabinetNumber='" + cabinetNumber + '\'' +
                ", businessOutletId=" + businessOutletId +
                ", warehouseId=" + warehouseId +
                ", stockingBase=" + stockingBase +
                ", districtId=" + districtId +
                ", residentialAreaId=" + residentialAreaId +
                ", location='" + location + '\'' +
                ", isFresh=" + isFresh +
                '}';
    }
}
