package com.pony.dao;

import com.pony.domain.ShoppingCartEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/31
 */
public interface ShoppingCartDAO {
    int insert(ShoppingCartEntry shoppingCartEntry);

    ShoppingCartEntry getShoppingCartEntryByPhoneAndProductIdAndAddress(
            @Param("phone") String phone, @Param("productId") int productId, @Param("addressId") int addressId);

    int updateByPhoneAndProduct(@Param("count") int count,
                                @Param("phone") String phone, @Param("productId") int productId);

    List<ShoppingCartEntry> getShoppingCartEntityByPhone(@Param("phone") String phone);

    /**
     * 根据购物车ID数组获取购物车链表
     *
     * @param
     * @return int[]
     */
    List<ShoppingCartEntry> getShoppingCartEntryByIds(@Param("shoppingCartIds") int[] shoppingCartIds);

    int updateStatusById(@Param("id") int id, @Param("status") int status);

    int updateStatusByAddressId(@Param("address_id") int addressId, @Param("status") int status);
}
