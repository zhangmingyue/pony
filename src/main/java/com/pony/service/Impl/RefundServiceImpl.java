package com.pony.service.Impl;

import com.pony.dao.RefundDAO;
import com.pony.domain.RefundEntry;
import com.pony.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int updateStatusById(int id, int status) {
        return refundDAO.updateStatusById(id, status);
    }

    @Override
    public List<RefundEntry> getRefundListByPhone(String phone) {
        return refundDAO.getRefundListByPhone(phone);
    }
}
