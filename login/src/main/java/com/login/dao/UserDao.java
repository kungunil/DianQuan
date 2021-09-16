package com.login.dao;

import com.login.entity.User;


public interface UserDao {
    User QueryUserByName(String username);
    int insertUser(User user);
}
