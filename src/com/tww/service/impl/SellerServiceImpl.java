package com.tww.service.impl;

import com.tww.dao.SellerDao;
import com.tww.entity.Seller;
import com.tww.service.SellerService;

import java.util.List;

/**
 * Created by tww on 2017/5/15.
 */
public class SellerServiceImpl implements SellerService {
    private SellerDao sellerDao;

    public SellerDao getSellerDao() {
        return sellerDao;
    }

    public void setSellerDao(SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    @Override
    public void save(Seller seller) {
        this.sellerDao.SaveSeller(seller);
    }

    @Override
    public List<Seller> findAll() {
        return this.sellerDao.findAllSeller();
    }

    @Override
    public void delete(Seller seller) {
        this.sellerDao.removeSeller(seller);
    }

    @Override
    public void update(Seller seller) {
        this.sellerDao.updateSeller(seller);
    }

    @Override
    public Seller findSellerById(Integer id) {
        return this.sellerDao.findSellerById(id);
    }

    @Override
    public Seller loginSeller(Seller seller) {
        return this.sellerDao.loginSeller(seller);
    }
}
