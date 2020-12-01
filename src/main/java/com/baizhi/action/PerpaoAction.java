package com.baizhi.action;

import com.baizhi.entity.Perpao;
import com.baizhi.service.PerpaoService;

import java.util.List;

public class PerpaoAction {
    private PerpaoService perpaoService;
    private List<Perpao> perpaos;
    private Perpao perpao;
    private String id;

    public List<Perpao> getPerpaos() {
        return perpaos;
    }

    public void setPerpaos(List<Perpao> perpaos) {
        this.perpaos = perpaos;
    }

    public Perpao getPerpao() {
        return perpao;
    }

    public void setPerpao(Perpao perpao) {
        this.perpao = perpao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerpaoService(PerpaoService perpaoService) {
        this.perpaoService = perpaoService;
    }

    //增加
    public String add() {
        perpaoService.save(perpao);
        return "queryAllAction";
    }

    //删除
    public String delete() {
        perpaoService.delete(id);
        return "queryAllAction";
    }

    //修改
    public String update() {
        perpaoService.update(perpao);
        return "queryAllAction";
    }

    //查所有
    public String queryAll() {
        this.perpaos = perpaoService.queryAll();
        return "queryAll";
    }

    //查一个
    public String queryOne() {
        perpao = perpaoService.queryOne(id);
        return "queryOne";
    }
}
