package com.pony.domain;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public class DistrictEntity {
    private int id;
    private String districtName;

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

    @Override
    public String toString() {
        return "DistrictEntity{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
