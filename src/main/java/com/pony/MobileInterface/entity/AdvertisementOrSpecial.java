package com.pony.MobileInterface.entity;

/**
 * 广告或专题
 * Created by zhangmingyue on 2017/3/2 0002.
 */
public class AdvertisementOrSpecial {

    private Advertisement advertisement;
    private Special special;
    private int weight;
    //setter and getter


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }
}
