package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserInfoByUserNameAndUserPwd(String UserName,String UserPwd);
}
