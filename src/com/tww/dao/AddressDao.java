package com.tww.dao;

import com.tww.entity.Address;
import com.tww.entity.User;

import java.util.List;

/**
 * Created by tww on 2017/4/28.
 */
public interface AddressDao {
    public void saveAddress(Address address);

    public List<Address> findAllAddress(Integer userID);

    public void removeAddress(Address address);

    public void updateAddress(Address address);
}
