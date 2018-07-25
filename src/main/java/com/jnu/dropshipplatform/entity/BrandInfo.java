package com.jnu.dropshipplatform.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BrandInfo {

    @Id
    @GeneratedValue
    private Integer brandId;
    @ManyToOne
    private CompanyInfo brandOwner;
    private String brandName;
    private String brandImage;

    public BrandInfo() {
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public CompanyInfo getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(CompanyInfo brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }
}
