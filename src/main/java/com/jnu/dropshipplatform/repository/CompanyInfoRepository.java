package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo,Integer> {
    //根据用户名和密码返回品牌商信息
    CompanyInfo findCompanyInfoByUserNameAndAndUserPwd(String userName,String userPwd);

    //判断用户名是否已存在
    Boolean existsCompanyInfoByUserName(String userName);

}
