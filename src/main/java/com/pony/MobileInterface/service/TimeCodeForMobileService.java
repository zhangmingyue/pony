package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.ProductTemp;
import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.productManage.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface TimeCodeForMobileService {

    /**
     * 根据查询条件获取商品链表
     *
     * @param shoppingCartIds
     * @return List<ProductTemp>
     */
    public List<ProductTemp> getProductTempList(String[] shoppingCartIds);



}
