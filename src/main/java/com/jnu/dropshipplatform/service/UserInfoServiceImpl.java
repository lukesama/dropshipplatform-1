package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.UserInfo;
import com.jnu.dropshipplatform.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findUserInfoByUserNameAndUserPwd(String userName, String userPwd) {
        return userInfoRepository.findUserInfoByUserNameAndUserPwd(userName,userPwd);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo getUserByName(String userName) {
        return userInfoRepository.findUserInfoByUserName(userName);
    }
}
