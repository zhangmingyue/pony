package com.pony.service.Impl;

import com.google.common.base.Strings;
import com.pony.dao.DistrictDAO;
import com.pony.domain.DistrictEntity;
import com.pony.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/9
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictDAO districtDAO;

    @Override
    public List<DistrictEntity> getAllList() {
        return districtDAO.getAllList();
    }

}
