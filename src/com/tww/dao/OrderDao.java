package com.tww.dao;

import com.tww.entity.Orderinfo;

import java.util.List;

/**
 * Created by tww on 2017/5/7.
 */
public interface OrderDao {
    public void saveOrder(Orderinfo order);

    public List<Orderinfo> findAllOrder(Integer userID);

    public void removeOrder(Orderinfo order);

    public void updateOrder(Orderinfo order);

    public Orderinfo findOrderByID(Integer ID);

    public List<Orderinfo> findOrderByIsAssessed(Integer userID);

    public List<Orderinfo> findAllOrderBySellerID(Integer sellerID);
}
