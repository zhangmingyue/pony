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
    private Integer userId;
    //订单状态0为待发货1为待自提
    private Integer state;
    //订单Id
    private Integer productOrderId;
    //子单类型0为现货1为预约
    private Integer childOrderType;
    //分页查询设置
    private int itemNumber = 10;
    private int pageNumber = 1;
    private int beginLine;
    //是否按时间过滤（7天）0否1是
    private int timeFilter = 0;
    //setter and getter


    public int getTimeFilter() {
        return timeFilter;
    }

    public void setTimeFilter(int timeFilter) {
        this.timeFilter = timeFilter;
    }

    public Integer getChildOrderType() {
        return childOrderType;
    }

    public void setChildOrderType(Integer childOrderType) {
        this.childOrderType = childOrderType;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getState() {
        return state;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getBeginLine() {
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



}
