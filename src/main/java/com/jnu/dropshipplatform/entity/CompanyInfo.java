package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CompanyInfo {

    @Id
    @GeneratedValue
    private Integer userComId;
    private String comName;
    private String comDescription;
    private String comLogo;
    private Double comBalance;
    private String userName;
    private String userPwd;
    private String realName;
    private Boolean userStatus;

    public CompanyInfo() {
    }

    public Integer getUserComId() {
        return userComId;
    }

    public void setUserComId(Integer userComId) {
        this.userComId = userComId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComDescription() {
        return comDescription;
    }

    public void setComDescription(String comDescription) {
        this.comDescription = comDescription;
    }

    public String getComLogo() {
        return comLogo;
    }

    public void setComLogo(String comLogo) {
        this.comLogo = comLogo;
    }

    public Double getComBalance() {
        return comBalance;
    }

    public void setComBalance(Double comBalance) {
        this.comBalance = comBalance;
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
