package com.tww.service;

import com.tww.entity.Goods;

import java.util.List;

/**
 * Created by tww on 2017/5/22.
 */
public interface GoodsService {
    public void save(Goods goods);

    public List<Goods> findAll(Integer sellerID);

    public Goods findById(Integer ID);

    public void delete(Goods goods);

    public void update(Goods goods);
}
