package com.tww.service.impl;

import com.tww.dao.OrderDao;
import com.tww.entity.Orderinfo;
import com.tww.service.OrderService;

import java.util.List;

/**
 * Created by tww on 2017/5/7.
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void save(Orderinfo Orderinfo) {
        this.orderDao.saveOrder(Orderinfo);
    }

    @Override
    public List<Orderinfo> findAll(Integer userID) {
        return this.orderDao.findAllOrder(userID);
    }

    @Override
    public void delete(Orderinfo Orderinfo) {
        this.orderDao.removeOrder(Orderinfo);
    }

    @Override
    public void update(Orderinfo Orderinfo) {
        this.orderDao.updateOrder(Orderinfo);
    }

    @Override
    public Orderinfo findByID(Integer ID) {
        return this.orderDao.findOrderByID(ID);
    }

    @Override
    public List<Orderinfo> findOrderByIsAssessed(Integer userID) {
        return this.orderDao.findOrderByIsAssessed(userID);
    }

    @Override
    public List<Orderinfo> findAllOrderBySellerID(Integer sellerID) {
        return this.orderDao.findAllOrderBySellerID(sellerID);
    }
}
