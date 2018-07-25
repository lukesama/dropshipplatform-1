package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.CompanyInfo;

import com.jnu.dropshipplatform.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {

    CompanyInfo getCompanyInfoById(Integer comId);

    //返回所有品牌商信息
    List<CompanyInfo> getAllCompany();

    //根据品牌商ID查找相应的信息
    CompanyInfo getCompanyById(Integer id);

    //添加品牌商信息
    CompanyInfo addCompanyInfo(CompanyInfo companyInfo);

    //根据品牌商ID删除相应的信息
    void deleteCompanyById(Integer id);

    //修改品牌商信息
    CompanyInfo updateCompanyInfo(CompanyInfo companyInfo);

//    //根据账号名和密码返回品牌商信息
//    CompanyInfo providerLogin(String username,String password);
}
