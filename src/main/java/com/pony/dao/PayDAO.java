package com.pony.dao;

import com.pony.domain.PayEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/15
 */
public interface PayDAO {

    int insert(PayEntity payEntity);

    PayEntity getPayEntityByOutTradeNo(@Param("out_trade_no") String outTradeNo);

    int changeStatusByOutTradeNo(@Param("out_trade_no") String outTradeNo);
}
