package com.pony.service.Impl;

import com.pony.dao.RefundDAO;
import com.pony.domain.RefundEntry;
import com.pony.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundDAO refundDAO;

    @Override
    public int insert(RefundEntry refundEntry) {
        return refundDAO.insert(refundEntry);
    }
}
