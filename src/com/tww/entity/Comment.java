package com.tww.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tww on 2017/5/27.
 */
@Entity
public class Comment {
    private int id;
    private Integer userId;
    private Integer sellerId;
    private Integer sellerStar;
    private Integer goodsStar;
    private String comment;
    private String time;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "sellerID")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "sellerStar")
    public Integer getSellerStar() {
        return sellerStar;
    }

    public void setSellerStar(Integer sellerStar) {
        this.sellerStar = sellerStar;
    }

    @Basic
    @Column(name = "goodsStar")
    public Integer getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(Integer goodsStar) {
        this.goodsStar = goodsStar;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (id != comment1.id) return false;
        if (userId != null ? !userId.equals(comment1.userId) : comment1.userId != null) return false;
        if (sellerId != null ? !sellerId.equals(comment1.sellerId) : comment1.sellerId != null) return false;
        if (sellerStar != null ? !sellerStar.equals(comment1.sellerStar) : comment1.sellerStar != null) return false;
        if (goodsStar != null ? !goodsStar.equals(comment1.goodsStar) : comment1.goodsStar != null) return false;
        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        if (time != null ? !time.equals(comment1.time) : comment1.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (sellerId != null ? sellerId.hashCode() : 0);
        result = 31 * result + (sellerStar != null ? sellerStar.hashCode() : 0);
        result = 31 * result + (goodsStar != null ? goodsStar.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
