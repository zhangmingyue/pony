package com.pony.service.Impl;

import com.pony.dao.PayDAO;
import com.pony.domain.PayEntity;
import com.pony.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/15
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    PayDAO payDAO;

    @Override
    public int insert(PayEntity payEntity) {
        return payDAO.insert(payEntity);
    }

    @Override
    public PayEntity getPayEntityByOutTradeNo(String outTradeNo) {
        return payDAO.getPayEntityByOutTradeNo(outTradeNo);
    }

    @Override
    public int changeStatusByOutTradeNo(String outTradeNo) {
        return payDAO.changeStatusByOutTradeNo(outTradeNo);
    }
}
