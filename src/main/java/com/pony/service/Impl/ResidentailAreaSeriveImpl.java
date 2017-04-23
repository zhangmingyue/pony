package com.pony.service.Impl;

import com.google.common.base.Strings;
import com.pony.dao.ResidentialAreaDAO;
import com.pony.domain.ResidentialAreaEntity;
import com.pony.service.ResidentialAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Service
public class ResidentailAreaSeriveImpl implements ResidentialAreaService {

    @Autowired
    ResidentialAreaDAO residentialAreaDAO;

    @Override
    public List<ResidentialAreaEntity> getAllList() {
        return residentialAreaDAO.getAllList();
    }

    @Override
    public List<ResidentialAreaEntity> getPartListByDistrictId(int districtId) {
        return residentialAreaDAO.getPartListByDistrictId(districtId);
    }

    @Override
    public Map<Integer, String> getPartListByDistrictIdMap(int districtId) {
        List<ResidentialAreaEntity> residentialAreaEntities = this.getPartListByDistrictId(districtId);
        Map<Integer, String> result = new HashMap<>();
        for (ResidentialAreaEntity residentialAreaEntity : residentialAreaEntities) {

            if (residentialAreaEntity != null) {
                int id = residentialAreaEntity.getId();
                String name = residentialAreaEntity.getResidentialAreaName();
                if (id >= 0 && !Strings.isNullOrEmpty(name)) {
                    result.put(id, name);
                }
            }
        }

        return result;
    }
}
