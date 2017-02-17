package com.pony.service;

import com.pony.domain.User;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
public interface UserService {

    /**
     * insert User
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 获取到所有User
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据电话号取User
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 检查电话号是否存在 存在true
     *
     * @param phone
     * @return
     */
    boolean checkPhoneExist(String phone);

    /**
     * 更新密码
     *
     * @param password
     * @return
     */
    boolean updatePasswordByPhone(String password, String phone);
}
