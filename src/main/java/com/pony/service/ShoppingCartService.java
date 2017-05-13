package com.pony.service;

import com.pony.domain.ShoppingCartEntry;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/31
 */
public interface ShoppingCartService {
    int insert(ShoppingCartEntry shoppingCartEntry);

    ShoppingCartEntry getShoppingCartEntryByPhoneAndProductIdAndAddress(
            String phone, int productId, int addressId);

    int updateByPhoneAndProduct(int count, String phone, int productId);

    List<ShoppingCartEntry> getShoppingCartEntityByPhone(String phone);

    int updateStatusById(int id, int status);

    boolean deleteById(int id);
}
