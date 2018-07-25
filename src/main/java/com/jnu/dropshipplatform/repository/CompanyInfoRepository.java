package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo,Integer> {
//    CompanyInfo findCompanyInfoByUserNameAndAndUserPwd(String userName,String userPwd);
}
