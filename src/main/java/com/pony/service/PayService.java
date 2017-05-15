package com.pony.service;

import com.pony.domain.PayEntity;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/15
 */
public interface PayService {

    int insert(PayEntity payEntity);

    PayEntity getPayEntityByOutTradeNo(String outTradeNo);

    int changeStatusByOutTradeNo(String outTradeNo);
}
