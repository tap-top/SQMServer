package com.tww.dao.impl;

import com.tww.dao.GoodsDao;
import com.tww.entity.Goods;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/5/22.
 */
public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao {
    @Override
    public void saveGoods(Goods goods) {
        this.getHibernateTemplate().save(goods);
    }

    @Override
    public List<Goods> findAllGoods(Integer sellerId) {
        String hql = "from Goods goods where goods.sellerId=" + sellerId + " order by goods.id desc";
        return (List<Goods>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public Goods findById(Integer Id) {
        Goods goods = (Goods) this.getHibernateTemplate().get(Goods.class, Id);
        return goods;
    }

    @Override
    public void removeGoods(Goods goods) {
        this.getHibernateTemplate().delete(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        this.getHibernateTemplate().update(goods);
    }
}
