package com.jnu.dropshipplatform.entity;

import javax.persistence.*;

@Entity
public class BrandProduct {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer productInfo;
    private Integer brandId;

    public BrandProduct() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Integer productInfo) {
        this.productInfo = productInfo;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
