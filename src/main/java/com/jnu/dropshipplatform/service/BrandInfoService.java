package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;

import java.util.List;

public interface BrandInfoService {
    List<BrandInfo> findBrandInfoByBrandOwner(CompanyInfo companyInfo);
}
