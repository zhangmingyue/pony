package com.pony.service;

import com.pony.MobileInterface.entity.ProductTemp;
import com.pony.domain.CollectionEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/8
 */
public interface CollectionService {
    int insert(CollectionEntity collectionEntity);

    List<CollectionEntity> getListByPhone(String phone);

    List<CollectionEntity> getListByPhoneAndProductId(String phone, int productId);
    void collectPurchasedProduct(String phone, List<ProductTemp> productTempList);
}
