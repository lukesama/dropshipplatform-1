package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessmanInfoRepository extends JpaRepository<BusinessmanInfo,Integer> {
    BusinessmanInfo findBusinessmanInfoByUserNameAndUserPwd(String userName,String userPwd);

    Boolean existsBusinessmanInfoByUserName(String userName);
}
