package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.repository.BrandInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandInfoServiceImpl implements BrandInfoService {

    @Autowired
    private BrandInfoRepository brandInfoRepository;

    @Override
    public List<BrandInfo> findBrandInfoByBrandOwner(CompanyInfo companyInfo) {
        return brandInfoRepository.findBrandInfosByBrandOwner(companyInfo);
    }
}
