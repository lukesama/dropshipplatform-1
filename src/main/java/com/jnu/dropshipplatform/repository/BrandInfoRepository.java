package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandInfoRepository extends JpaRepository<BrandInfo,Integer> {
    List<BrandInfo> findBrandInfosByBrandOwner(CompanyInfo companyInfo);
}
