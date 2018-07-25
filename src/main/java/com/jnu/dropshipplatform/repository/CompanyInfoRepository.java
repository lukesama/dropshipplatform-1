package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo,Integer> {
    CompanyInfo findCompanyInfoByUserComId(Integer UserComId);
}
