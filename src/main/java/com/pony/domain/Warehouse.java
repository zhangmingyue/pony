package com.pony.domain;

/**
 * Created by Administrator on 2017/4/4 0004.
 * 仓库
 */
public class Warehouse {

    private int id;
    //仓库名字
    private String warehouseName;
    //备货基数
    private int stockingBase;
    //父仓库id
    private int fatherWarehouseId;

    //gettter and getter


    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getStockingBase() {
        return stockingBase;
    }

    public void setStockingBase(int stockingBase) {
        this.stockingBase = stockingBase;
    }

    public int getFatherWarehouseId() {
        return fatherWarehouseId;
    }

    public void setFatherWarehouseId(int fatherWarehouseId) {
        this.fatherWarehouseId = fatherWarehouseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
