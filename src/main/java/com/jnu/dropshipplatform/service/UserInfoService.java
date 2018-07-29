package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo findUserInfoByUserNameAndUserPwd(String userName,String userPwd);
    List<UserInfo> findAll();

    UserInfo getUserByName(String userName);
}
