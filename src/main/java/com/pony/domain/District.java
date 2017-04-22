package com.pony.domain;

/**
 * 城区
 * Created by Administrator on 2017/4/4 0004.
 */
public class District {

    private int id;
    //城区名字如海淀区
    private String districtName;

    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
