package com.tww.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by tww on 2017/5/25.
 */
@Entity
public class Seller {
    private int sellerId;
    private String brand;
    private String sellerName;
    private String stars;
    private String monthSelled;
    private Integer sellerTime;
    private Double distance;
    private BigDecimal startPrice;
    private String dispatchPrice;
    private BigDecimal perCaptitaPrice;
    private String sellerPhone;
    private String sellerAddress;
    private String sellerPassword;

    @Id
    @Column(name = "sellerID")
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "sellerName")
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Basic
    @Column(name = "stars")
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "monthSelled")
    public String getMonthSelled() {
        return monthSelled;
    }

    public void setMonthSelled(String monthSelled) {
        this.monthSelled = monthSelled;
    }

    @Basic
    @Column(name = "sellerTime")
    public Integer getSellerTime() {
        return sellerTime;
    }

    public void setSellerTime(Integer sellerTime) {
        this.sellerTime = sellerTime;
    }

    @Basic
    @Column(name = "distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "startPrice")
    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
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
    @Column(name = "perCaptitaPrice")
    public BigDecimal getPerCaptitaPrice() {
        return perCaptitaPrice;
    }

    public void setPerCaptitaPrice(BigDecimal perCaptitaPrice) {
        this.perCaptitaPrice = perCaptitaPrice;
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
    @Column(name = "sellerAddress")
    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    @Basic
    @Column(name = "sellerPassword")
    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        if (sellerId != seller.sellerId) return false;
        if (brand != null ? !brand.equals(seller.brand) : seller.brand != null) return false;
        if (sellerName != null ? !sellerName.equals(seller.sellerName) : seller.sellerName != null) return false;
        if (stars != null ? !stars.equals(seller.stars) : seller.stars != null) return false;
        if (monthSelled != null ? !monthSelled.equals(seller.monthSelled) : seller.monthSelled != null) return false;
        if (sellerTime != null ? !sellerTime.equals(seller.sellerTime) : seller.sellerTime != null) return false;
        if (distance != null ? !distance.equals(seller.distance) : seller.distance != null) return false;
        if (startPrice != null ? !startPrice.equals(seller.startPrice) : seller.startPrice != null) return false;
        if (dispatchPrice != null ? !dispatchPrice.equals(seller.dispatchPrice) : seller.dispatchPrice != null)
            return false;
        if (perCaptitaPrice != null ? !perCaptitaPrice.equals(seller.perCaptitaPrice) : seller.perCaptitaPrice != null)
            return false;
        if (sellerPhone != null ? !sellerPhone.equals(seller.sellerPhone) : seller.sellerPhone != null) return false;
        if (sellerAddress != null ? !sellerAddress.equals(seller.sellerAddress) : seller.sellerAddress != null)
            return false;
        if (sellerPassword != null ? !sellerPassword.equals(seller.sellerPassword) : seller.sellerPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sellerId;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (monthSelled != null ? monthSelled.hashCode() : 0);
        result = 31 * result + (sellerTime != null ? sellerTime.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (startPrice != null ? startPrice.hashCode() : 0);
        result = 31 * result + (dispatchPrice != null ? dispatchPrice.hashCode() : 0);
        result = 31 * result + (perCaptitaPrice != null ? perCaptitaPrice.hashCode() : 0);
        result = 31 * result + (sellerPhone != null ? sellerPhone.hashCode() : 0);
        result = 31 * result + (sellerAddress != null ? sellerAddress.hashCode() : 0);
        result = 31 * result + (sellerPassword != null ? sellerPassword.hashCode() : 0);
        return result;
    }
}
