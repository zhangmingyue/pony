package com.pony.service.Impl;

import com.pony.dao.ShoppingCartDAO;
import com.pony.domain.ShoppingCartEntry;
import com.pony.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/31
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Override
    public synchronized int insert(ShoppingCartEntry shoppingCartEntry) {
        return shoppingCartDAO.insert(shoppingCartEntry);
    }

    @Override
    public ShoppingCartEntry getShoppingCartEntryByPhoneAndProductIdAndAddress
            (String phone, int productId, int addressId) {
        return shoppingCartDAO.
                getShoppingCartEntryByPhoneAndProductIdAndAddress(phone, productId, addressId);
    }

    @Override
    public int updateByPhoneAndProduct(int count, String phone, int productId) {
        return shoppingCartDAO.updateByPhoneAndProduct(count, phone, productId);
    }

    @Override
    public List<ShoppingCartEntry> getShoppingCartEntityByPhone(String phone) {
        return shoppingCartDAO.getShoppingCartEntityByPhone(phone);
    }
}
