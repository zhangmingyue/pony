package com.pony.service;

import com.pony.domain.ResidentialAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface ResidentialAreaService {

    List<ResidentialAreaEntity> getAllList();

    List<ResidentialAreaEntity> getPartListByDistrictId(int districtId);

    Map<Integer,String> getPartListByDistrictIdMap(int districtId);

    ResidentialAreaEntity getResidentialAreaEntityById(int id);
}
