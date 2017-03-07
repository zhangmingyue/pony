package com.pony.MobileInterface.entity;

import com.pony.productManage.entity.Product;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Accessors(chain = true)
public class Special {

    private int id;
    //专题题目
    private String title;
    //专题介绍
    private String specialIntroduction;
    //专题图片URL进入专题后最上面的图片
    private String specialPictureUrl;
    //专题封面图片url同广告图片
    private String coverPageUrl;
    //专题文本项列表
    private List<SpecialTextItem> SpecialTextItemList;
    //专题权重
    private int weight;
    //产品列表
    private List<Product> productList;
    //封面图片高
    private int coverPageHigh;
    //封面图片宽
    private int coverPageWidth;
    //setter and getter


    public int getCoverPageHigh() {
        return coverPageHigh;
    }

    public void setCoverPageHigh(int coverPageHigh) {
        this.coverPageHigh = coverPageHigh;
    }

    public int getCoverPageWidth() {
        return coverPageWidth;
    }

    public void setCoverPageWidth(int coverPageWidth) {
        this.coverPageWidth = coverPageWidth;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<SpecialTextItem> getSpecialTextItemList() {
        return SpecialTextItemList;
    }

    public void setSpecialTextItemList(List<SpecialTextItem> specialTextItemList) {
        SpecialTextItemList = specialTextItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialIntroduction() {
        return specialIntroduction;
    }

    public void setSpecialIntroduction(String specialIntroduction) {
        this.specialIntroduction = specialIntroduction;
    }

    public String getSpecialPictureUrl() {
        return specialPictureUrl;
    }

    public void setSpecialPictureUrl(String specialPictureUrl) {
        this.specialPictureUrl = specialPictureUrl;
    }

    public String getCoverPageUrl() {
        return coverPageUrl;
    }

    public void setCoverPageUrl(String coverPageUrl) {
        this.coverPageUrl = coverPageUrl;
    }
}
