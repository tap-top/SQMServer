package com.tww.dao;

import com.tww.entity.Goods;

import java.util.List;

/**
 * Created by tww on 2017/5/22.
 */
public interface GoodsDao {
    public void saveGoods(Goods goods);

    public List<Goods> findAllGoods(Integer sellerId);

    public Goods findById(Integer Id);

    public void removeGoods(Goods goods);

    public void updateGoods(Goods goods);
}
