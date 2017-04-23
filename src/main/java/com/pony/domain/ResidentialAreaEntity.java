package com.pony.domain;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public class ResidentialAreaEntity {
    private int id;
    private String residentialAreaName;
    private int districId;
    private int building;
    private int house;
    private int housePrice;
    private int cabinetCount;
    private int rentOne;
    private int rentTwo;
    private int rentThree;

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

    public int getDistricId() {
        return districId;
    }

    public void setDistricId(int districId) {
        this.districId = districId;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public int getCabinetCount() {
        return cabinetCount;
    }

    public void setCarbinetCount(int cabinetCount) {
        this.cabinetCount = cabinetCount;
    }

    public int getRentOne() {
        return rentOne;
    }

    public void setRentOne(int rentOne) {
        this.rentOne = rentOne;
    }

    public int getRentTwo() {
        return rentTwo;
    }

    public void setRentTwo(int rentTwo) {
        this.rentTwo = rentTwo;
    }

    public int getRentThree() {
        return rentThree;
    }

    public void setRentThree(int rentThree) {
        this.rentThree = rentThree;
    }

    @Override
    public String toString() {
        return "ResidentialAreaEntity{" +
                "id=" + id +
                ", residentialAreaName='" + residentialAreaName + '\'' +
                ", districId=" + districId +
                ", building=" + building +
                ", house=" + house +
                ", housePrice=" + housePrice +
                ", cabinetCount=" + cabinetCount +
                ", rentOne=" + rentOne +
                ", rentTwo=" + rentTwo +
                ", rentThree=" + rentThree +
                '}';
    }
}
