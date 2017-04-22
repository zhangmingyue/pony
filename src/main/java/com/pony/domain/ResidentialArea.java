package com.pony.domain;

/**
 * Created by Administrator on 2017/4/4 0004.
 */
public class ResidentialArea {

    private int id;
    //小区名字如花园小区
    private String residentialAreaName;

    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResidentialAreaName() {
        return residentialAreaName;
    }

    public void setResidentialAreaName(String residentialAreaName) {
        this.residentialAreaName = residentialAreaName;
    }
}
