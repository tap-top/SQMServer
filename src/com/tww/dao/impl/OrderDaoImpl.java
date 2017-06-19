package com.tww.dao.impl;

import com.tww.dao.OrderDao;
import com.tww.entity.Orderinfo;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/5/7.
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {
    @Override
    public void saveOrder(Orderinfo order) {
        this.getHibernateTemplate().save(order);
    }

    @Override
    public List<Orderinfo> findAllOrder(Integer userID) {
        String hql = "from Orderinfo order1 where order1.userId=" + userID +" order by order1.id desc";
        return (List<Orderinfo>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void removeOrder(Orderinfo order) {
        this.getHibernateTemplate().delete(order);
    }

    @Override
    public void updateOrder(Orderinfo order) {
        this.getHibernateTemplate().update(order);
    }

    @Override
    public Orderinfo findOrderByID(Integer ID) {
        Orderinfo orderinfo = (Orderinfo) this.getHibernateTemplate().get(Orderinfo.class, ID);
        return orderinfo;
    }

    @Override
    public List<Orderinfo> findOrderByIsAssessed(Integer userID) {
        String hql = "from Orderinfo order1 where order1.userId=" + userID +" and assessed="+0+" and state='订单已完成' order by order1.id desc";
        return (List<Orderinfo>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Orderinfo> findAllOrderBySellerID(Integer sellerID) {
        String hql = "from Orderinfo order1 where order1.sellerId=" + sellerID +" and assessed="+0+" order by order1.id desc";
//        String hql = "from Orderinfo order1 where order1.sellerId=" + sellerID +" and assessed="+0+" and state!='订单已完成' order by order1.id desc";
        return (List<Orderinfo>) this.getHibernateTemplate().find(hql);
    }
}
