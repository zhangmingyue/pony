package com.pony.dao;

import com.pony.domain.RefundEntry;
import org.apache.ibatis.annotations.Param;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
public interface RefundDAO {

    int insert(RefundEntry refundEntry);

    int updateStatusById(@Param("id") int id, @Param("status") int status);
}
