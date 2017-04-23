package com.pony.dao;

import com.pony.domain.ShoppingCartEntry;
import org.apache.ibatis.annotations.Param;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/31
 */
public interface ShoppingCartDAO {
    int insert(ShoppingCartEntry shoppingCartEntry);

    ShoppingCartEntry getShoppingCartEntryByPhoneAndProductIdAndAddress(
            @Param("phone") String phone, @Param("productId") int productId,@Param("addressId") int addressId);

    int updateByPhoneAndProduct(@Param("count") int count,
                                @Param("phone") String phone, @Param("productId") int productId);
}
