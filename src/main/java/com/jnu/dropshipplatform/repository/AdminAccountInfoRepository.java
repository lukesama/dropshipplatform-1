package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.AdminAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountInfoRepository extends JpaRepository<AdminAccountInfo,Integer> {

    AdminAccountInfo findAdminAccountInfoByAdminUserNameAndAdminUserPwd(String userName,String UserPwd);

}
