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

}
