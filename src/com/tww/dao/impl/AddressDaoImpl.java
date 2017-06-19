package com.tww.dao.impl;

import com.tww.dao.AddressDao;
import com.tww.entity.Address;
import com.tww.entity.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/4/28.
 */
public class AddressDaoImpl extends HibernateDaoSupport implements AddressDao {
    @Override
    public void saveAddress(Address address) {
        this.getHibernateTemplate().save(address);
    }

    @Override
    public List<Address> findAllAddress(Integer userID) {
        String hql = "from Address address where address.userId = " + userID + " order by address.id desc";
        return (List<Address>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void removeAddress(Address address) {
        this.getHibernateTemplate().delete(address);
    }

    @Override
    public void updateAddress(Address address) {
        this.getHibernateTemplate().update(address);
    }
}
