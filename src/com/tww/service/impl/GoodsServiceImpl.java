package com.tww.service.impl;

import com.tww.dao.GoodsDao;
import com.tww.entity.Goods;
import com.tww.service.GoodsService;

import java.util.List;

/**
 * Created by tww on 2017/5/22.
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void save(Goods goods) {
        this.goodsDao.saveGoods(goods);
    }

    @Override
    public List<Goods> findAll(Integer sellerID) {
        return this.goodsDao.findAllGoods(sellerID);
    }

    @Override
    public Goods findById(Integer ID) {
        return this.goodsDao.findById(ID);
    }

    @Override
    public void delete(Goods goods) {
        this.goodsDao.removeGoods(goods);
    }

    @Override
    public void update(Goods goods) {
        this.goodsDao.updateGoods(goods);
    }
}
