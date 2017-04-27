package com.pony.service.Impl;

import com.pony.MobileInterface.entity.ProductTemp;
import com.pony.dao.CollectionDAO;
import com.pony.domain.CollectionEntity;
import com.pony.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/8
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionDAO collectionDAO;

    @Override
    public int insert(CollectionEntity collectionEntity) {
        return collectionDAO.insert(collectionEntity);
    }

    @Override
    public List<CollectionEntity> getListByPhone(String phone) {
        return collectionDAO.getListByPhone(phone);
    }

    @Override
    public List<CollectionEntity> getListByPhoneAndProductId(String phone, int productId) {
        return collectionDAO.getListByPhoneAndProductId(phone, productId);
    }
    @Override
    public void collectPurchasedProduct(String phone, List<ProductTemp> productTempList){
        CollectionEntity collectionEntity;
        for(ProductTemp pt:productTempList){
            List<CollectionEntity> collectionEntities = getListByPhoneAndProductId(phone, pt.getProduct().getId());
            //如果用户收藏过则返回1,不储存
            if (collectionEntities != null && !collectionEntities.isEmpty()) {
                continue;
            }
            Date time = new Date();
            collectionEntity = new CollectionEntity();
            collectionEntity.setPhone(phone);
            collectionEntity.setProductId(pt.getProduct().getId());
            collectionEntity.setTime(time);
            insert(collectionEntity);
        }

    }
}
