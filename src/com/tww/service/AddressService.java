package com.tww.service;

import com.tww.entity.Address;
import com.tww.entity.User;

import java.util.List;

/**
 * Created by tww on 2017/4/30.
 */
public interface AddressService {
    public void save(Address address);

    public List<Address> findAll(Integer userID);

    public void delete(Address address);

    public void update(Address address);
}
