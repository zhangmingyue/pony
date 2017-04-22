package com.pony.MobileInterface.entity.queryBean;

import lombok.experimental.Accessors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 子订单查询条件类
 */
@Accessors(chain = true)
public class ChildOrderQueryBean {

    //用户ID
    private int userId;
    //订单状态0为待发货1为待自提
    private int state;
    //订单Id
    private int productOrderId;
    //子单类型0为现货1为预约
    private int childOrderType;
    //分页查询设置
    private int itemNumber = 10;
    private int pageNumber = 1;
    private int beginLine;
    //setter and getter


    public int getChildOrderType() {
        return childOrderType;
    }

    public void setChildOrderType(int childOrderType) {
        this.childOrderType = childOrderType;
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getState() {
        return state;
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

    public int getBeginLine() {
        return beginLine;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setState(int state) {
        this.state = state;
    }



}
