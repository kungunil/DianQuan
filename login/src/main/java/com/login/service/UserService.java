package com.login.service;

import com.login.entity.User;


public interface UserService {
     int addUser(User user);
     User findUser(String username);
}
