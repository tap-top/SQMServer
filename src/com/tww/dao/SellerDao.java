package com.tww.dao;

import com.tww.entity.Seller;

import java.util.List;

/**
 * Created by tww on 2017/5/15.
 */
public interface SellerDao {
    public void SaveSeller(Seller seller);

    public List<Seller> findAllSeller();

    public void removeSeller(Seller seller);

    public void updateSeller(Seller seller);

    public Seller findSellerById(Integer id);


    public Seller loginSeller(Seller seller);
}
