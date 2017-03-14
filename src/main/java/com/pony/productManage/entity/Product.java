package com.pony.productManage.entity;

import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
/**
 * 产品
 * Created by zhangmingyue on 2017/3/1 0001.
 */
@Accessors(chain = true)
public class Product {

    private int id;
    //产品名
    private String productName;
    //促销价
    private double promotionPrice;
    //产品编号
    private String productNumber;
    //是否现货
    private int isSpot;
    //产品图标图片路径
    private String productIconUrl;
    //是否促销
    private int promotion;
    //排名权重
    private int weight;
    //长
    private int length;
    //高
    private int high;
    //宽
    private int width;
    //促销开始时间
    private Date promotionBeginTime;
    //促销结束时间
    private Date promotionEndTime;
    //ID限购量
    private int idRestrictionNumber;
    //限购信用分数
    private int creditScore;
    //参与促销数量
    private int promotionNumber;
    //产品图片链表
    private List<ProductPicture> productPictures;
    //产品原价
    private double originalPrice;
    //预约名称
    private String reservation;
    //产品一级类目代码
    private String categoryCodeOne;
    //产品二级类目代码
    private String categoryCodetTwo;
    //产品三级类目代码
    private String categoryCodeThree;
    //产品单位
    private String unit;


    //setter and getter


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getCategoryCodeOne() {
        return categoryCodeOne;
    }

    public void setCategoryCodeOne(String categoryCodeOne) {
        this.categoryCodeOne = categoryCodeOne;
    }

    public String getCategoryCodetTwo() {
        return categoryCodetTwo;
    }

    public void setCategoryCodetTwo(String categoryCodetTwo) {
        this.categoryCodetTwo = categoryCodetTwo;
    }

    public String getCategoryCodeThree() {
        return categoryCodeThree;
    }

    public void setCategoryCodeThree(String categoryCodeThree) {
        this.categoryCodeThree = categoryCodeThree;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public List<ProductPicture> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(List<ProductPicture> productPictures) {
        this.productPictures = productPictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getIsSpot() {
        return isSpot;
    }

    public void setIsSpot(int isSpot) {
        this.isSpot = isSpot;
    }

    public String getProductIconUrl() {
        return productIconUrl;
    }

    public void setProductIconUrl(String productIconUrl) {
        this.productIconUrl = productIconUrl;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Date getPromotionBeginTime() {
        return promotionBeginTime;
    }

    public void setPromotionBeginTime(Date promotionBeginTime) {
        this.promotionBeginTime = promotionBeginTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public int getIdRestrictionNumber() {
        return idRestrictionNumber;
    }

    public void setIdRestrictionNumber(int idRestrictionNumber) {
        this.idRestrictionNumber = idRestrictionNumber;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getPromotionNumber() {
        return promotionNumber;
    }

    public void setPromotionNumber(int promotionNumber) {
        this.promotionNumber = promotionNumber;
    }
}
