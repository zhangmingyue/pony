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
    private Date beginTime;
    //广告结束时间
    private Date endTime;
    //广告权重
    private int weight;
    //广告关联产品ID
    private int productId;
    //广告图片高
    private int pictureHigh;
    //广告图片宽
    private int pictureWidth;

    //setter and getter


    public int getPictureHigh() {
        return pictureHigh;
    }

    public void setPictureHigh(int pictureHigh) {
        this.pictureHigh = pictureHigh;
    }

    public int getPictureWidth() {
        return pictureWidth;
    }

    public void setPictureWidth(int pictureWidth) {
        this.pictureWidth = pictureWidth;
    }

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
