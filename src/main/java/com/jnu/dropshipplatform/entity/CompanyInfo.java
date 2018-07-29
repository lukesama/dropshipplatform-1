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
    private Integer userStatus;
    private String phone;

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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
