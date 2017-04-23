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
    public synchronized int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDAO.getUserByPhone(phone);
    }

    @Override
    public boolean checkPhoneExist(String phone) {
        User user = getUserByPhone(phone);
        return user != null && user.getPassword() != null;
    }

    @Override
    public synchronized boolean updatePasswordByPhone(String password, String phone) {
        return userDAO.updatePasswordByPhone(password, phone);
    }

    @Override
    public boolean checkPhoneAndPassword(String phone, String password) {

        List<User> users = userDAO.getUserByPhoneAndPassword(phone, password);
        return !(users == null || users.isEmpty());
    }

    @Override
    public User getCreditByUserId(int id) {
        return userDAO.getCreditByUserId(id);
    }
}
