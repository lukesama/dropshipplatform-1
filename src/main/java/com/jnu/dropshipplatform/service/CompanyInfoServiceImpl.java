package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

}
