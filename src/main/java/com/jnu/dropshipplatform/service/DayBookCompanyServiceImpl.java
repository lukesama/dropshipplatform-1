package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.entity.DayBookCompany;
import com.jnu.dropshipplatform.repository.DayBookCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayBookCompanyServiceImpl implements DayBookCompanyService {

    @Autowired
    private DayBookCompanyRepository dayBookCompanyRepository;

    @Override
    public List<DayBookCompany> findDayBookCompanyByCompanyInfo(CompanyInfo companyInfo) {
        return dayBookCompanyRepository.findDayBookCompaniesByCompany(companyInfo);
    }

    @Override
    public void save(DayBookCompany dayBookCompany) {
        dayBookCompanyRepository.save(dayBookCompany);
    }
}
