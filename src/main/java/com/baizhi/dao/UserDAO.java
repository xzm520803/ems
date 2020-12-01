package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
    //注册
    void save(User user);

    //登陆
    User queryOne(String username);
}
