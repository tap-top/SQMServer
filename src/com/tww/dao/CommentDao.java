package com.tww.dao;

import com.tww.entity.Comment;

import java.util.List;

/**
 * Created by tww on 2017/5/27.
 */
public interface CommentDao {
    public void AddComment(Comment comment);

    public List<Comment> FindCommentBySellerID(Integer sellerID);

    public List<Comment> FindCommentBuUserID(Integer userID);
}
