package com.jnu.dropshipplatform.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProductAndCategory {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer proId;
    private String proName;
    private String proTitle;
    //    @OneToOne
//    private ProductCategory proCategoryId;
    private Integer proCategoryId;
    private Double droPrice;
    private Integer proStock;
    private String proModel;
    private String proImage;
    private  String cateName;

    public ProductAndCategory(Integer proId,String proName, String proTitle, Integer proCategoryId, Double droPrice, Integer proStock, String proModel, String proImage, String cateName) {
        this.proId=proId;
        this.proName = proName;
        this.proTitle = proTitle;
        this.proCategoryId = proCategoryId;
        this.droPrice = droPrice;
        this.proStock = proStock;
        this.proModel = proModel;
        this.proImage = proImage;
        this.cateName = cateName;
    }

    public ProductAndCategory() {

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

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
