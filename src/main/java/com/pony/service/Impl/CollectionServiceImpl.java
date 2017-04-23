package com.pony.service.Impl;

import com.pony.dao.CollectionDAO;
import com.pony.domain.CollectionEntity;
import com.pony.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
