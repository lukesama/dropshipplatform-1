package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.entity.DayBookCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayBookCompanyRepository extends JpaRepository<DayBookCompany,Integer> {
    List<DayBookCompany> findDayBookCompaniesByCompany(CompanyInfo companyInfo);
}
