package com.pony.dao;

import com.pony.domain.CollectionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/8
 */
public interface CollectionDAO {

    int insert(CollectionEntity collectionEntity);

    List<CollectionEntity> getListByPhone(@Param("phone") String phone);

    List<CollectionEntity> getListByPhoneAndProductId(@Param("phone") String phone, @Param("product_id") int productId);
}
