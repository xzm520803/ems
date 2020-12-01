package com.baizhi.dao;

import com.baizhi.entity.Perpao;

import java.util.List;

public interface PerpaoDAO {
    //增加
    void save(Perpao perpao);

    //删除
    void delete(String id);

    //修改
    void update(Perpao perpao);

    //查询
    List<Perpao> queryAll();

    //查一个
    Perpao queryOne(String id);
}
