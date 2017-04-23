package com.pony.MobileInterface.entity;

/**
 * Created by Administrator on 2017/4/7 0007.
 * 库存
 */
public class Stock {

    private int id;
    //库存
    private int inventory;
    //告警值
    private int alarmThreshold;
    //仓库ID
    private int warehouseId;
    //产品ID
    private int productId;

    //setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(int alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
