package com.pony.MobileInterface.entity;

import com.pony.productManage.entity.Product;

/**
 * Created by Administrator on 2017/4/6 0006.
 * 子订单中的产品
 */
public class ChildOrderProduct {

    private int id;
    //子订单Id
    private int childOrderId;
    //产品ID
    private int productId;
    //产品
    private Product product;
    //地址ID
    private int addressId;
    //库存ID
    private int stockId;
    //库存数量
    private int stockNumber;
    //购买数量
    private int purchaseNumber;
    //购买时的价格
    private double purchasePrice;

    //setter and getter


    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(int childOrderId) {
        this.childOrderId = childOrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }
}
