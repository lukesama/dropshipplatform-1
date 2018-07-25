package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.CompanyInfo;

public interface CompanyInfoService {
    CompanyInfo findCompanyInfoByUserComId(Integer id);
}
