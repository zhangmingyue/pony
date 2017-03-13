package com.pony.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public class AddressDAO {
    private int id;
    private String address;
    private String name;
    private int custom;
    private Date dt;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustom() {
        return custom;
    }

    public void setCustom(int custom) {
        this.custom = custom;
    }

    public Date getDate() {
        return dt;
    }

    public void setDate(Date dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "AddressDAO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", custom=" + custom +
                ", date=" + dt +
                '}';
    }
}
