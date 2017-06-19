package com.tww.service.impl;

import com.tww.dao.CommentDao;
import com.tww.entity.Comment;
import com.tww.service.CommentService;

import java.util.List;

/**
 * Created by tww on 2017/5/27.
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void save(Comment comment) {
        this.commentDao.AddComment(comment);
    }

    @Override
    public List<Comment> FindCommentBySellerID(Integer sellerID) {
        return this.commentDao.FindCommentBySellerID(sellerID);
    }

    @Override
    public List<Comment> FindCommentBuUserID(Integer userID) {
        return this.commentDao.FindCommentBuUserID(userID);
    }
}
