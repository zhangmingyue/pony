package com.pony.productManage.entity;

import lombok.experimental.Accessors;

/**
 * 产品图片
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Accessors(chain = true)
public class ProductPicture {

    private int id;

    private int productId;
    //产品图片URL
    private String productPictureUrl;
    //是否为主展示图
    private int coverpicture;


    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductPictureUrl() {
        return productPictureUrl;
    }

    public void setProductPictureUrl(String productPictureUrl) {
        this.productPictureUrl = productPictureUrl;
    }

    public int getCoverpicture() {
        return coverpicture;
    }

    public void setCoverpicture(int coverpicture) {
        this.coverpicture = coverpicture;
    }
}
