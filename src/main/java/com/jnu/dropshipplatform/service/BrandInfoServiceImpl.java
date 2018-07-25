package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.BrandInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandInfoServiceImpl implements BrandInfoService {

    @Autowired
    private BrandInfoRepository brandInfoRepository;

}
