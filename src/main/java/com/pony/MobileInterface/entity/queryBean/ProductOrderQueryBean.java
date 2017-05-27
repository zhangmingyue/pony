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
public class ProductOrderQueryBean {

    //用户ID
    private Integer userId;
    //订单状态0为待付款
    private Integer state = 0;
    //订单Id
    private int orderId;
    //分页查询设置
    private int itemNumber = 10;
    private int pageNumber = 1;
    private int beginLine;

    //setter and getter


    public Integer getUserId() {
        return userId;
    }

    public Integer getState() {
        return state;
    }

    public int getOrderId() {
        return orderId;
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
        beginLine = (pageNumber-1)*itemNumber;
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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
