package com.pony.MobileInterface.entity;

import java.util.Date;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 * 广告类
 */
public class Advertisement {

    private int id;
    //广告图片URL
    private String advertisementPictureUrl;
    //广告投放开始时间
    private Date begainTime;
    //广告结束时间
    private Date endTime;
    //广告权重
    private int weight;
    //广告关联产品ID
    private int productId;

    //setter and getter


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

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

    public String getAdvertisementPictureUrl() {
        return advertisementPictureUrl;
    }

    public void setAdvertisementPictureUrl(String advertisementPictureUrl) {
        this.advertisementPictureUrl = advertisementPictureUrl;
    }

    public Date getBegainTime() {
        return begainTime;
    }

    public void setBegainTime(Date begainTime) {
        this.begainTime = begainTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
