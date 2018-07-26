package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.AdminAccountInfo;
import com.jnu.dropshipplatform.repository.AdminAccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountInfoServiceImpl implements AdminAccountInfoService {

    @Autowired
    private AdminAccountInfoRepository adminAccountInfoRepository;

    @Override
    public AdminAccountInfo adminLogin(String userName, String userPwd) {
        return adminAccountInfoRepository.findAdminAccountInfoByAdminUserNameAndAdminUserPwd(userName,userPwd);
    }
}

