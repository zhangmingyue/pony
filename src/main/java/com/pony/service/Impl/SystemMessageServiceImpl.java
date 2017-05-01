package com.pony.service.Impl;

import com.pony.dao.SystemMessageDAO;
import com.pony.domain.SystemMessage;
import com.pony.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/30
 */
@Service
public class SystemMessageServiceImpl implements SystemMessageService {
    @Autowired
    SystemMessageDAO systemMessageDAO;

    @Override
    public int insert(SystemMessage systemMessage) {
        return systemMessageDAO.insert(systemMessage);
    }

    @Override
    public List<SystemMessage> getSystemMessageByPhone(String phone) {
        return systemMessageDAO.getSystemMessageByPhone(phone);
    }
}
