package com.pony.service;

import com.pony.dao.AddressDAO;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public interface AddressService {

    int insert(AddressDAO addressDAO);

    List<String> getAddressListByPhone(String phone);
}
