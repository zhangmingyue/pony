package com.pony.dao;

import com.pony.MobileInterface.entity.Advertisement;
import com.pony.MobileInterface.entity.Special;
import com.pony.MobileInterface.entity.SpecialTextItem;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;
import com.pony.productManage.entity.ProductPicture;
import com.pony.productManage.entity.ProductPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface SpecialAndAdvertisementForMobileDAO {


    /**
     * 获取首页最上端广告
     *
     * @param currentTime
     * @return List<Product>
     */
    public Advertisement getTopAdvertisement(@Param("currentTime")String currentTime);
    /**
     * 按权重获取广告列表
     *
     * @param currentTime
     * @return List<Advertisement>
     */
    public List<Advertisement> getAdvertisementByWeight(@Param("currentTime")String currentTime);
    /**
     * 按权重获取专题列表
     *
     * @param currentTime
     * @return List<Product>
     */
    public List<Special> getSpecialListByWeight(@Param("currentTime")String currentTime);
    /**
     * 按专题ID获取文本项列表
     *
     * @param specialId
     * @return List<SpecialTextItem>
     */
    public List<SpecialTextItem> getSpecialTextItemListBySpecialId(@Param("specialId")Integer specialId);
    /**
     * 按专题ID获取产品列表
     *
     * @param specialId
     * @return List<Product>
     */
    public List<Product> getProductListBySpecialId(@Param("specialId")Integer specialId);
    /**
     * 按专题ID获取专题
     *
     * @param specialId
     * @return Special
     */
    public Special getSpecialBySpecialId(@Param("specialId")Integer specialId);

}
