package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer cateId;
    private Integer fatherCateId;
    private String cateName;
    private String catePath;

    public ProductCategory() {
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getFatherCateId() {
        return fatherCateId;
    }

    public void setFatherCateId(Integer fatherCateId) {
        this.fatherCateId = fatherCateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCatePath() {
        return catePath;
    }

    public void setCatePath(String catePath) {
        this.catePath = catePath;
    }
}
