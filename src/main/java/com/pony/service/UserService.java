package com.pony.service;

import com.pony.domain.User;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
public interface UserService {

    int insert (User user);

    List<User> getAllUser();
}
