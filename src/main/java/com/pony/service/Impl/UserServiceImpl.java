package com.pony.service.Impl;

import com.pony.dao.UserDAO;
import com.pony.domain.User;
import com.pony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
}