package com.tww.service.impl;

import com.tww.dao.AddressDao;
import com.tww.entity.Address;
import com.tww.entity.User;
import com.tww.service.AddressService;

import java.util.List;

/**
 * Created by tww on 2017/4/30.
 */
public class AddressServiceImpl implements AddressService{
    private AddressDao addressDao;

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void save(Address address) {
        this.addressDao.saveAddress(address);
    }

    @Override
    public List<Address> findAll(Integer userID) {
        return this.addressDao.findAllAddress(userID);
    }

    @Override
    public void delete(Address address) {
        this.addressDao.removeAddress(address);
    }

    @Override
    public void update(Address address) {
        this.addressDao.updateAddress(address);
    }
}
