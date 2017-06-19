package com.tww.dao.impl;

import com.tww.dao.CommentDao;
import com.tww.entity.Comment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tww on 2017/5/27.
 */
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
    @Override
    public void AddComment(Comment comment) {
        this.getHibernateTemplate().save(comment);
    }

    @Override
    public List<Comment> FindCommentBySellerID(Integer sellerID) {
        String hql = "from Comment comment where comment.sellerId = " + sellerID + " order by comment.id desc";
        return (List<Comment>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Comment> FindCommentBuUserID(Integer userID) {
        String hql = "from Comment comment where comment.userId = " + userID + " order by comment.id desc";
        return (List<Comment>) this.getHibernateTemplate().find(hql);
    }
}
