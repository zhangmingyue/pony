package com.pony.service;

import com.pony.domain.AddressEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public interface AddressService {

    int insert(AddressEntity addressEntity);

    List<AddressEntity> getAddressByPhone(String phone);

    AddressEntity getAddressById(int id);
}
