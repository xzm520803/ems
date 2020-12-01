package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //登陆 查一个
    @Override
    public User queryOne(String username) {
        User user = userDAO.queryOne(username);
        return user;
    }

    //注册  添加
    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }
}
