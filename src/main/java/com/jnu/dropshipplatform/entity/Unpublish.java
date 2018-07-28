package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Unpublish {

    @Id
    @GeneratedValue
    private Integer id;
    private String proTitle;
    @ManyToOne
    private BusinessmanInfo businessmanInfo;

    public Unpublish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    public BusinessmanInfo getBusinessmanInfo() {
        return businessmanInfo;
    }

    public void setBusinessmanInfo(BusinessmanInfo businessmanInfo) {
        this.businessmanInfo = businessmanInfo;
    }
}
