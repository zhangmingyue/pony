package com.pony.service.Impl;

import com.pony.dao.TestDAO;
import com.pony.domain.TestEntry;
import com.pony.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDao;

    @Override
    public List<TestEntry> getAllTest() {
        return testDao.getAllTest();
    }

    @Override
    public int insert(TestEntry testEntry) {
        return testDao.insert(testEntry);
    }
}
