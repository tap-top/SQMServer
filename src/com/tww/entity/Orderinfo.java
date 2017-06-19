package com.tww.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tww on 2017/5/27.
 */
@Entity
public class Orderinfo {
    private int id;
    private Integer userId;
    private String title;
    private String logo;
    private String state;
    private String info;
    private String assessed;
    private String sellerId;
    private String allcount;
    private String allprice;
    private String sellerPhone;
    private String dispatchPrice;
    private String address;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "assessed")
    public String getAssessed() {
        return assessed;
    }

    public void setAssessed(String assessed) {
        this.assessed = assessed;
    }

    @Basic
    @Column(name = "sellerID")
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "allcount")
    public String getAllcount() {
        return allcount;
    }

    public void setAllcount(String allcount) {
        this.allcount = allcount;
    }

    @Basic
    @Column(name = "allprice")
    public String getAllprice() {
        return allprice;
    }

    public void setAllprice(String allprice) {
        this.allprice = allprice;
    }

    @Basic
    @Column(name = "sellerPhone")
    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    @Basic
    @Column(name = "dispatchPrice")
    public String getDispatchPrice() {
        return dispatchPrice;
    }

    public void setDispatchPrice(String dispatchPrice) {
        this.dispatchPrice = dispatchPrice;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

        Orderinfo orderinfo = (Orderinfo) o;

        if (id != orderinfo.id) return false;
        if (userId != null ? !userId.equals(orderinfo.userId) : orderinfo.userId != null) return false;
        if (title != null ? !title.equals(orderinfo.title) : orderinfo.title != null) return false;
        if (logo != null ? !logo.equals(orderinfo.logo) : orderinfo.logo != null) return false;
        if (state != null ? !state.equals(orderinfo.state) : orderinfo.state != null) return false;
        if (info != null ? !info.equals(orderinfo.info) : orderinfo.info != null) return false;
        if (assessed != null ? !assessed.equals(orderinfo.assessed) : orderinfo.assessed != null) return false;
        if (sellerId != null ? !sellerId.equals(orderinfo.sellerId) : orderinfo.sellerId != null) return false;
        if (allcount != null ? !allcount.equals(orderinfo.allcount) : orderinfo.allcount != null) return false;
        if (allprice != null ? !allprice.equals(orderinfo.allprice) : orderinfo.allprice != null) return false;
        if (sellerPhone != null ? !sellerPhone.equals(orderinfo.sellerPhone) : orderinfo.sellerPhone != null)
            return false;
        if (dispatchPrice != null ? !dispatchPrice.equals(orderinfo.dispatchPrice) : orderinfo.dispatchPrice != null)
            return false;
        if (address != null ? !address.equals(orderinfo.address) : orderinfo.address != null) return false;
        if (time != null ? !time.equals(orderinfo.time) : orderinfo.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (assessed != null ? assessed.hashCode() : 0);
        result = 31 * result + (sellerId != null ? sellerId.hashCode() : 0);
        result = 31 * result + (allcount != null ? allcount.hashCode() : 0);
        result = 31 * result + (allprice != null ? allprice.hashCode() : 0);
        result = 31 * result + (sellerPhone != null ? sellerPhone.hashCode() : 0);
        result = 31 * result + (dispatchPrice != null ? dispatchPrice.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
