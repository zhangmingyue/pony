package com.pony.dao;

import com.pony.domain.SystemMessage;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/30
 */
public interface SystemMessageDAO {

    int insert(SystemMessage systemMessage);

    List<SystemMessage> getSystemMessageByPhone(String phone);
}
