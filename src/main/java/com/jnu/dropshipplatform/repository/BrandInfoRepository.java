package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandInfoRepository extends JpaRepository<BrandInfo,Integer> {

    List<BrandInfo> findBrandInfoByBrandOwner_UserComId(Integer userComId);

}
