package com.pony.service.Impl;

import com.pony.dao.AddressDAO;
import com.pony.domain.AddressEntity;
import com.pony.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/26
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDAO addressDAO;

    @Override
    public int insert(AddressEntity addressEntity) {
        return addressDAO.insert(addressEntity);
    }

    @Override
    public List<AddressEntity> getAddressByPhone(String phone) {
        return addressDAO.getAddressByPhone(phone);
    }

    @Override
    public AddressEntity getAddressById(int id) {
        return addressDAO.getAddressByAddressId(id);
    }

    @Override
    public boolean setDefaultAddressById(int id, int defaultAddress) {
        return addressDAO.setDefaultAddressById(id, defaultAddress);
    }

    @Override
    public boolean setZeroDefaultAddress(String phone) {
        return addressDAO.setZeroDefaultAddress(phone);
    }

    @Override
    public int updateRemoveStatus(int id, int status) {
        return addressDAO.updateRemoveStatus(id, status);
    }

}
