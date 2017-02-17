package com.pony.dao;

import com.pony.domain.TestEntry;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
public interface TestDAO {

    List<TestEntry> getAllTest();

    int insert(TestEntry testEntry);
}
