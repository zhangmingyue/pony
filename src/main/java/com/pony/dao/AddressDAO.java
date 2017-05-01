package com.pony.dao;

import org.apache.ibatis.annotations.Param;

import com.pony.domain.AddressEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
public interface AddressDAO {

    int insert(AddressEntity addressEntity);

    List<String> getAddressListByPhone(String phone);

    /**
     * 根据地址ID获取地址信息
     *
     * @param addressId
     * @return List<ChildOrderProduct>
     */
    AddressEntity getAddressByAddressId(@Param("addressId") Integer addressId);

    List<AddressEntity> getAddressByPhone(String phone);

    boolean setDefaultAddressById(@Param("id") int id,
                                  @Param("default_address") int defaultAddress);

    boolean setZeroDefaultAddress(@Param("phone") String phone);
}
