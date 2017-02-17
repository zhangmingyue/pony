package com.pony.dao;

import com.pony.domain.User;
import org.apache.ibatis.annotations.Param;

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

    boolean updatePasswordByPhone(@Param("password")String password,
                                  @Param("phone")String phone);
}
