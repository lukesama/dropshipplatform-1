package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    @Override
    public List<CompanyInfo> getAllCompany() {
        return companyInfoRepository.findAll();
    }

    @Override
    public CompanyInfo getCompanyById(Integer id) {
        return companyInfoRepository.findById(id).get();
    }

    @Override
    public CompanyInfo addCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    @Override
    public void deleteCompanyById(Integer id) {
        companyInfoRepository.deleteById(id);
    }

    @Override
    public CompanyInfo updateCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

//    @Override
//    public CompanyInfo providerLogin(String username, String password) {
//        return companyInfoRepository.findCompanyInfoByUserNameAndAndUserPwd(username,password);
//    }
}
