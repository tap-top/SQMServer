package com.tww.dao.impl;

import com.tww.dao.SellerDao;
import com.tww.entity.Seller;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/5/15.
 */
public class SellerDaoImpl extends HibernateDaoSupport implements SellerDao {
    @Override
    public void SaveSeller(Seller seller) {
        this.getHibernateTemplate().save(seller);
    }

    @Override
    public List<Seller> findAllSeller() {
        String hql = "from Seller seller order by seller.sellerId desc";
        return (List<Seller>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void removeSeller(Seller seller) {
        this.getHibernateTemplate().delete(seller);
    }

    @Override
    public void updateSeller(Seller seller) {
        this.getHibernateTemplate().update(seller);
    }

    @Override
    public Seller findSellerById(Integer id) {
        Seller seller = (Seller) this.getHibernateTemplate().get(Seller.class, id);

        return seller;
    }

    @Override
    public Seller loginSeller(Seller seller) {
        String hql = "from Seller seller where seller.sellerName='"
                + seller.getSellerName() + "' and seller.sellerPassword='"
                + seller.getSellerPassword() + "'";
        List<Seller> sellers = (List<Seller>) this.getHibernateTemplate().find(hql);
        if (sellers.size() > 0) {
            return sellers.get(0);
        }
        return null;
    }
}
