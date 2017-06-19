package com.tww.service;

import com.tww.entity.Orderinfo;

import java.util.List;

/**
 * Created by tww on 2017/5/7.
 */
public interface OrderService {
    public void save(Orderinfo Orderinfo);

    public List<Orderinfo> findAll(Integer userID);

    public void delete(Orderinfo Orderinfo);

    public void update(Orderinfo Orderinfo);

    public Orderinfo findByID(Integer ID);

    public List<Orderinfo> findOrderByIsAssessed(Integer userID);

    public List<Orderinfo> findAllOrderBySellerID(Integer sellerID);

}
