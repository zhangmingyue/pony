package com.pony.service;

import com.pony.domain.TestEntry;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
public interface TestService {

    List<TestEntry> getAllTest();

    int insert(TestEntry testEntry);
}
