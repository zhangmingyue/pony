package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.Advertisement;
import com.pony.MobileInterface.entity.AdvertisementOrSpecial;
import com.pony.MobileInterface.entity.Special;
import com.pony.MobileInterface.entity.SpecialTextItem;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface SpecialAndAdvertisementService {

    /**
     * 获取首页最上端广告
     *
     * @param currentTime
     * @return List<Product>
     */
    public Advertisement getTopAdvertisement();

    /**
     * 获取专题或广告列表
     *
     *
     * @return List<Product>
     */
    public List<AdvertisementOrSpecial> getAdvertisementOrSpecialList();


    /**
     * 按专题ID获取专题
     *
     * @param specialId
     * @return Special
     */
    public Special getSpecialBySpecialId(Integer specialId);
}
