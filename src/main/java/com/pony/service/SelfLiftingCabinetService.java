package com.pony.service;


import com.pony.domain.SelfLiftingCabinetEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
public interface SelfLiftingCabinetService {

    List<SelfLiftingCabinetEntity> getSelfLiftingCabinetByResidential(int residentialAreaId);

    SelfLiftingCabinetEntity getSelfLiftingCabinetById(int id);
}
