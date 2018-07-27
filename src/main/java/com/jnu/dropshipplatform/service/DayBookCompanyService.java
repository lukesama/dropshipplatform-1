package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.entity.DayBookCompany;

import java.util.List;

public interface DayBookCompanyService {
    List<DayBookCompany> findDayBookCompanyByCompanyInfo(CompanyInfo companyInfo);
    void save(DayBookCompany dayBookCompany);

    List<DayBookCompany> getAllCpyDayBook();
    DayBookCompany findDayBookCpyByID(Integer ID);
 }
