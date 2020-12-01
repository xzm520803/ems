package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    //登陆
    User queryOne(String username);

    //注册
    void save(User user);
}
