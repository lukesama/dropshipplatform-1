package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;

import java.util.List;

public interface BusinessmanInfoService {
    //根据ID找借卖方信息
    BusinessmanInfo getBusiInfoByID(Integer userBusiId);
    //修改借卖方信息
    BusinessmanInfo updateBusiInfo(BusinessmanInfo businessmanInfo);

    BusinessmanInfo addBusiInfo(BusinessmanInfo businessmanInfo);

    BusinessmanInfo businessmanLogin(String userName,String userPwd);

    Boolean existUserName(String userName);

}
