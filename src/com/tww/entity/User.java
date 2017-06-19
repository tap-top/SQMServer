package com.tww.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tww on 2017/5/1.
 */
@Entity
public class User {
    private int userid;
    private String username;
    private String userpassword;
    private String phonenum;
    private String headimg;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpassword")
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "phonenum")
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Basic
    @Column(name = "headimg")
    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (userpassword != null ? !userpassword.equals(user.userpassword) : user.userpassword != null) return false;
        if (phonenum != null ? !phonenum.equals(user.phonenum) : user.phonenum != null) return false;
        if (headimg != null ? !headimg.equals(user.headimg) : user.headimg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpassword != null ? userpassword.hashCode() : 0);
        result = 31 * result + (phonenum != null ? phonenum.hashCode() : 0);
        result = 31 * result + (headimg != null ? headimg.hashCode() : 0);
        return result;
    }
}
