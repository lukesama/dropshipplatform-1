package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.repository.BusinessmanInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessmanInfoServiceImpl implements BusinessmanInfoService {

    @Autowired
    private BusinessmanInfoRepository businessmanInfoRepository;

    @Override
    public BusinessmanInfo getBusiInfoByID(Integer userBusiId){
        return businessmanInfoRepository.getOne(userBusiId);
    }
    @Override
    public BusinessmanInfo updateBusiInfo(BusinessmanInfo businessmanInfo) {
        return businessmanInfoRepository.save(businessmanInfo);
    }

    @Override
    public BusinessmanInfo businessmanLogin(String userName, String userPwd) {
        return businessmanInfoRepository.findBusinessmanInfoByUserNameAndUserPwd(userName,userPwd);
    }

    @Override
    public Boolean existUserName(String userName) {
        return businessmanInfoRepository.existsBusinessmanInfoByUserName(userName);
    }

    @Override
    public BusinessmanInfo addBusiInfo(BusinessmanInfo businessmanInfo) {
        return businessmanInfoRepository.save(businessmanInfo);
    }

    @Override
    public List<BusinessmanInfo> getAllBusinessmanInfo() {
        return businessmanInfoRepository.findAll();
    }
}
