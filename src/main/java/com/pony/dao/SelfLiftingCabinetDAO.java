package com.pony.dao;

import com.pony.domain.SelfLiftingCabinetEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface SelfLiftingCabinetDAO {

    List<SelfLiftingCabinetEntity> getSelfLiftingCabinetByResidential(@Param("residential_area_id") int residentialAreaId);
}
