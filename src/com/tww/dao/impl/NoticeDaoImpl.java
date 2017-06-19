package com.tww.dao.impl;

import com.tww.dao.NoticeDao;
import com.tww.entity.Notice;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/5/9.
 */
public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {
    @Override
    public void saveNotice(Notice notice) {
        this.getHibernateTemplate().save(notice);
    }

    @Override
    public List<Notice> findAllNotice(Integer userID) {
        String hql = "from Notice notice where notice.userId = " + userID + " order by notice.id desc";
        return (List<Notice>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void removeNotice(Notice notice) {
        this.getHibernateTemplate().delete(notice);
    }

    @Override
    public void updateNotice(Notice notice) {
        this.getHibernateTemplate().update(notice);
    }
}
