package com.baizhi.service;

import com.baizhi.dao.PerpaoDAO;
import com.baizhi.entity.Perpao;

import java.util.List;
import java.util.UUID;

public class PerpaoServiceImpl implements PerpaoService {
    private PerpaoDAO perpaoDAO;

    public void setPerpaoDAO(PerpaoDAO perpaoDAO) {
        this.perpaoDAO = perpaoDAO;
    }

    //增加
    @Override
    public void save(Perpao perpao) {
        perpao.setId(UUID.randomUUID().toString());
        perpaoDAO.save(perpao);
    }

    //删除
    @Override
    public void delete(String id) {
        perpaoDAO.delete(id);
    }

    //修改
    @Override
    public void update(Perpao perpao) {
        perpaoDAO.update(perpao);
    }

    //查所有
    @Override
    public List<Perpao> queryAll() {
        List<Perpao> perpaos = perpaoDAO.queryAll();
        return perpaos;
    }

    //查一个
    @Override
    public Perpao queryOne(String id) {
        Perpao perpao = perpaoDAO.queryOne(id);
        return perpao;
    }
}
