package com.pony.dao;

import com.pony.domain.DistrictEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface DistrictDAO {

    int insert(DistrictEntity districtEntity);

    List<DistrictEntity> getAllList();

    DistrictEntity getDistrictById(@Param("id") int id);
}
