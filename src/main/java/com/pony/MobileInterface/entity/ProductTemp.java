package com.pony.MobileInterface.entity;

import com.pony.productManage.entity.Product;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
public class ProductTemp {

    //产品ID
    private int productId;
    //产品
    private Product product;
    //产品长
    private int productLength;
    //产品宽
    private int productWidth;
    //产品高
    private int productHigh;
    //体积
    private int volume;
    //数量
    private int number;

    //setter and getter


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductLength() {
        return productLength;
    }

    public void setProductLength(int productLength) {
        this.productLength = productLength;
    }

    public int getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(int productWidth) {
        this.productWidth = productWidth;
    }

    public int getProductHigh() {
        return productHigh;
    }

    public void setProductHigh(int productHigh) {
        this.productHigh = productHigh;
    }

    public int getVolume() {
        return productLength*productWidth*productHigh;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
