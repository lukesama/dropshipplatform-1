package com.jnu.dropshipplatform.service;


import com.jnu.dropshipplatform.entity.AdminAccountInfo;


public interface AdminAccountInfoService {

    AdminAccountInfo adminLogin(String userName,String userPwd);

}
