package com.pony.productManage.entity;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 产品分类用于给消费者展示分类
 */
public class ProductType {

    private int id;
    //类目名称
    private String productTypeName;
    //父类目ID
    private int parentId;
    //子类目列表
    private List<ProductType> productTypeList;
    //产品类别图片URL
    private String productTypeIconUrl;

    //setter and getter


    public String getProductTypeIconUrl() {
        return productTypeIconUrl;
    }

    public void setProductTypeIconUrl(String productTypeIconUrl) {
        this.productTypeIconUrl = productTypeIconUrl;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
