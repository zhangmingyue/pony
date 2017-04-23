package com.pony.dao;

import com.pony.domain.ResidentialAreaEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface ResidentialAreaDAO {

    List<ResidentialAreaEntity> getAllList();

    List<ResidentialAreaEntity> getPartListByDistrictId(@Param("district_id") int districtId);
}
