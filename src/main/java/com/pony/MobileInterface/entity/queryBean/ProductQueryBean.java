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
public class ProductQueryBean {
    //按商品是否开始或结束促销和参与促销数量查询促销商品 日期格式2011-09-20 08:30:45
    private String promotionBeginTime;
    private String promotionEndTime;
    private String currentTime;
    //是否查询促销0为非促销，1为排队抢，2为信用福利
    private int promotionType = 0;
    //按商品ID查询商品
    private int productId = -1;
    //按商品名称模糊查询商品
    private String productName;
    //分页查询设置
    private int itemNumber = 10;
    private int pageNumber = 1;
    private int beginLine;
    //按商品类别查询
    private int productType;
    //排序规则 0不排序， 1 权重 ，2 销量，3 价格，4 新品
    private int orderByColumn = 0;
    //升降序规则 0降序，1升序 仅价格使用（当orderByColumn等于3时）
    private int ascOrDesc = 1;
    //促销预告 0为当前促销， 1为预告
    private int trailer=0;
    //setter and getter


    public int getTrailer() {
        return trailer;
    }

    public void setTrailer(int trailer) {
        this.trailer = trailer;
    }

    public int getAscOrDesc() {
        return ascOrDesc;
    }

    public void setAscOrDesc(int ascOrDesc) {
        this.ascOrDesc = ascOrDesc;
    }

    public int getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(int orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public int getBeginLine() {
        beginLine = (pageNumber-1)*itemNumber;
        return beginLine;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public int getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(int promotionType) {
        this.promotionType = promotionType;
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        currentTime = dateFormat.format(new Date());
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName.replaceAll("\\s+", "%");
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getPromotionBeginTime() {
        return promotionBeginTime;
    }

    public void setPromotionBeginTime(String promotionBeginTime) {
        this.promotionBeginTime = promotionBeginTime;
    }


    public String getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(String promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }
}
