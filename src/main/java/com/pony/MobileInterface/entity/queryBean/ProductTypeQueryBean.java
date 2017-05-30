package com.pony.MobileInterface.entity.queryBean;

import lombok.experimental.Accessors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 产品查询条件类
 */
@Accessors(chain = true)
public class ProductTypeQueryBean {

    //产品类目ID
    private int productTypeId = -1;
    private int parentId = -1;
    //分页查询设置
    //是否分页
    private int ispage = -1;
    private int itemNumber = 10;
    private int pageNumber = 1;
    private int beginLine;
    //排序规则 0不排序， 1 权重 ，2 销量，3 价格，4 新品
    private int orderByColumn = 0;
    //升降序规则 0降序，1升序 仅价格使用（当orderByColumn等于3时）
    private int ascOrDesc = 1;


    //setter and getter



    public int getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(int orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public int getAscOrDesc() {
        return ascOrDesc;
    }

    public void setAscOrDesc(int ascOrDesc) {
        this.ascOrDesc = ascOrDesc;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getBeginLine() {
        beginLine = (pageNumber-1)*itemNumber;
        return beginLine;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getIspage() {
        return ispage;
    }

    public void setIspage(int ispage) {
        this.ispage = ispage;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
