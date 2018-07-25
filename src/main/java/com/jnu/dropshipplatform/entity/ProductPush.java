package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductPush {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private ProductInfo proId;
    @ManyToOne
    private BusinessmanInfo busiId;
    private Double sellPrice;

    public ProductPush() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductInfo getProId() {
        return proId;
    }

    public void setProId(ProductInfo proId) {
        this.proId = proId;
    }

    public BusinessmanInfo getBusiId() {
        return busiId;
    }

    public void setBusiId(BusinessmanInfo busiId) {
        this.busiId = busiId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
