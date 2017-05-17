package com.pony.service;

import com.pony.domain.RefundEntry;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
public interface RefundService {

    int insert(RefundEntry refundEntry);

    int updateStatusById(int id, int status);
}
