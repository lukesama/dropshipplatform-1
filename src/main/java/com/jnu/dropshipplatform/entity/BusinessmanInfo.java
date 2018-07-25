package com.jnu.dropshipplatform.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusinessmanInfo {
    //借卖方信息表
    @Id
    @GeneratedValue
    private Integer userBusiId;
    private String busiName;
    private String supplierName;
    private String supplierUrl;
    private Double busiBalance;
    private String userName;
    private String userPwd;
    private String realName;
    private Boolean userStatus;

    public BusinessmanInfo() {
    }

    public Integer getUserBusiId() {
        return userBusiId;
    }

    public void setUserBusiId(Integer userBusiId) {
        this.userBusiId = userBusiId;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierUrl() {
        return supplierUrl;
    }

    public void setSupplierUrl(String supplierUrl) {
        this.supplierUrl = supplierUrl;
    }

    public Double getBusiBalance() {
        return busiBalance;
    }

    public void setBusiBalance(Double busiBalance) {
        this.busiBalance = busiBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }
}
