package com.pony.MobileInterface.entity;

import lombok.experimental.Accessors;

/**
 * Created by zhangmingyue on 2017/3/3 0003.
 */
@Accessors(chain = true)
public class SpecialTextItem {

    private int id;
    private String text;
    private String itemPictureUrl;
    private String pictureIntroduction;
    private int specialId;

    //setter and getter


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
