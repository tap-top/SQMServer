package com.tww.service;

import com.tww.entity.Comment;

import java.util.List;

/**
 * Created by tww on 2017/5/27.
 */
public interface CommentService {
    public void save(Comment comment);

    public List<Comment> FindCommentBySellerID(Integer sellerID);

    public List<Comment> FindCommentBuUserID(Integer userID);
}
