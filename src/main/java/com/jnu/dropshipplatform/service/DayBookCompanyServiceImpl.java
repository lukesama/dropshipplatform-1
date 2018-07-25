package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.DayBookCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayBookCompanyServiceImpl implements DayBookCompanyService {

    @Autowired
    private DayBookCompanyRepository dayBookCompanyRepository;
}
