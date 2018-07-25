package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.BusinessmanInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessmanInfoServiceImpl implements BusinessmanInfoService {

    @Autowired
    private BusinessmanInfoRepository businessmanInfoRepository;

}
