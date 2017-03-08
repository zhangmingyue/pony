package com.pony.MobileInterface.entity;

import lombok.experimental.Accessors;

/**
 * 专题文本项
 * Created by zhangmingyue on 2017/3/3 0003.
 */
@Accessors(chain = true)
public class SpecialTextItem {

    private int id;
    //文本
    private String text;
    //文本图片URL
    private String itemPictureUrl;
    //图片介绍（图片下面的小字）
    private String pictureIntroduction;
    //专题ID
    private int specialId;
    //文本项排序
    private int textItemOrder;


    //setter and getter


    public int getTextItemOrder() {
        return textItemOrder;
    }

    public void setTextItemOrder(int textItemOrder) {
        this.textItemOrder = textItemOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getItemPictureUrl() {
        return itemPictureUrl;
    }

    public void setItemPictureUrl(String itemPictureUrl) {
        this.itemPictureUrl = itemPictureUrl;
    }

    public String getPictureIntroduction() {
        return pictureIntroduction;
    }

    public void setPictureIntroduction(String pictureIntroduction) {
        this.pictureIntroduction = pictureIntroduction;
    }

    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }
}
