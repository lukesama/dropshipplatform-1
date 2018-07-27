package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdminAccountInfo {
    @Id
    @GeneratedValue
    private Integer adminId;
    private String adminUserName;
    private String adminUserPwd;

    public AdminAccountInfo() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminUserPwd() {
        return adminUserPwd;
    }

    public void setAdminUserPwd(String adminUserPwd) {
        this.adminUserPwd = adminUserPwd;
    }
}
