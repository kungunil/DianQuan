package com.login.service.impl;

import com.login.dao.UserDao;
import com.login.entity.User;
import com.login.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        int rows = userDao.insertUser(user);
        return rows;
    }

    @Override
    public User findUser(String username) {
        User rel= userDao.QueryUserByName(username);
        return rel;
    }
}
