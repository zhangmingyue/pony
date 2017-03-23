package com.pony.service.Impl;

import com.pony.dao.AddressDAO;
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
    public int insert(AddressDAO addressDAO) {
        return addressDAO.insert(addressDAO);
    }

    @Override
    public List<String> getAddressListByPhone(String phone) {
        return addressDAO.getAddressListByPhone(phone);
    }
}
