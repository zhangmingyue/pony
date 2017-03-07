package com.pony.productManage.entity;

import lombok.experimental.Accessors;

import java.util.Date;

/**
 *
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Accessors(chain = true)
public class ProductPrice {

    private int id;
    //关联的产品
    private Product product;
    //关联的产品ID
    private int productId;
    //产品价格
    private double price;
    //价格启用时间
    private Date enableDate;

    //setter and getter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Date enableDate) {
        this.enableDate = enableDate;
    }
}
