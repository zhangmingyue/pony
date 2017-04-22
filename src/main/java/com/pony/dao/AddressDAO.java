package com.pony.dao;

import com.pony.MobileInterface.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public interface AddressDAO {

    int insert(AddressDAO addressDAO);

    List<String> getAddressListByPhone(String phone);
    /**
     * 根据地址ID获取地址信息
     *
     * @param addressId
     * @return List<ChildOrderProduct>
     */
    Address getAddressByAddressId(@Param("addressId") Integer addressId);
}
