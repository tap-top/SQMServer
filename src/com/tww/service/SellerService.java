package com.tww.service;

import com.tww.entity.Seller;

import java.util.List;

/**
 * Created by tww on 2017/5/15.
 */
public interface SellerService {
    public void save(Seller seller);

    public List<Seller> findAll();

    public void delete(Seller seller);

    public void update(Seller seller);

    public Seller findSellerById(Integer id);

    public Seller loginSeller(Seller seller);
}
