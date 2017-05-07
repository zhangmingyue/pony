package com.pony.domain;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
public class CategoryEntity {
    private int id;
    private String name;
    private String type;
    private String parent;
    private Date date;
    private int isFresh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIsFresh() {
        return isFresh;
    }

    public void setIsFresh(int isFresh) {
        this.isFresh = isFresh;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parent='" + parent + '\'' +
                ", date=" + date +
                ", isFresh=" + isFresh +
                '}';
    }
}
