package com.pony.dao;

import com.pony.domain.User;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
public interface UserDAO {

    int insert(User user);

    List<User> getAllUser();

    User getUserByPhone(String phone);

    boolean updatePasswordByPhone(String password, String phone);
}
