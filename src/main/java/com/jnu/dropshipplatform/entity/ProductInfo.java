package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductInfo {

    @Id
    @GeneratedValue
    private Integer proId;
    private String proName;
    private String proTitle;
//    @OneToOne
//    private ProductCategory proCategoryId;
    private Integer proCategoryId;
    private Double droPrice;
    private Integer proStock;
    private String proModel;
    private String proDescription;
    private String proImage;
    private Integer proStatus;
    private Boolean pushStatus;

    public ProductInfo() {
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

//    public ProductCategory getProCategoryId() {
//        return proCategoryId;
//    }
//
//    public void setProCategoryId(ProductCategory proCategoryId) {
//        this.proCategoryId = proCategoryId;
//    }

    public Integer getProCategoryId() {
        return proCategoryId;
    }

    public void setProCategoryId(Integer proCategoryId) {
        this.proCategoryId = proCategoryId;
    }

    public Double getDroPrice() {
        return droPrice;
    }

    public void setDroPrice(Double droPrice) {
        this.droPrice = droPrice;
    }

    public Integer getProStock() {
        return proStock;
    }

    public void setProStock(Integer proStock) {
        this.proStock = proStock;
    }

    public String getProModel() {
        return proModel;
    }

    public void setProModel(String proModel) {
        this.proModel = proModel;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public Boolean getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Boolean pushStatus) {
        this.pushStatus = pushStatus;
    }
}
