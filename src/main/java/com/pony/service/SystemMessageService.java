package com.pony.service;

import com.pony.domain.SystemMessage;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/30
 */
public interface SystemMessageService {
    /**
     * systemMessage 字段含义请参照sql.change
     *
     * @param systemMessage
     * @return
     */
    int insert(SystemMessage systemMessage);

    List<SystemMessage> getSystemMessageByPhone(String phone);
}
