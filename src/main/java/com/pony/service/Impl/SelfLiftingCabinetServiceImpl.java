package com.pony.service.Impl;

import com.pony.dao.SelfLiftingCabinetDAO;
import com.pony.domain.SelfLiftingCabinetEntity;
import com.pony.service.SelfLiftingCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/12
 */
@Service
public class SelfLiftingCabinetServiceImpl implements SelfLiftingCabinetService {

    @Autowired
    SelfLiftingCabinetDAO selfLiftingCabinetDAO;

    @Override
    public List<SelfLiftingCabinetEntity> getSelfLiftingCabinetByResidential(int residentialAreaId) {
        return selfLiftingCabinetDAO.getSelfLiftingCabinetByResidential(residentialAreaId);
    }
}
