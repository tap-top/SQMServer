package com.tww.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by tww on 2017/5/22.
 */
@Entity
public class Goods {
    private int id;
    private Integer sellerId;
    private String name;
    private String info;
    private String sale;
    private BigDecimal price;
    private String image;
    private Integer praise;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sellerId")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "sale")
    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "praise")
    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (sellerId != null ? !sellerId.equals(goods.sellerId) : goods.sellerId != null) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (info != null ? !info.equals(goods.info) : goods.info != null) return false;
        if (sale != null ? !sale.equals(goods.sale) : goods.sale != null) return false;
        if (price != null ? !price.equals(goods.price) : goods.price != null) return false;
        if (image != null ? !image.equals(goods.image) : goods.image != null) return false;
        if (praise != null ? !praise.equals(goods.praise) : goods.praise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sellerId != null ? sellerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (sale != null ? sale.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (praise != null ? praise.hashCode() : 0);
        return result;
    }
}
