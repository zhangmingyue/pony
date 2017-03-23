package com.pony.dao;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public interface AddressDAO {

    int insert(AddressDAO addressDAO);

    List<String> getAddressListByPhone(String phone);
}
