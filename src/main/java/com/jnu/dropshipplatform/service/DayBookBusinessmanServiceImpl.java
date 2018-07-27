package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.DayBookBusinessman;
import com.jnu.dropshipplatform.repository.DayBookBusinessmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayBookBusinessmanServiceImpl implements DayBookBusinessmanService {

    @Autowired
    private DayBookBusinessmanRepository dayBookBusinessmanRepository;

    @Override
    public List<DayBookBusinessman> findDaybookByBussinessman(BusinessmanInfo businessmanInfo) {
        return dayBookBusinessmanRepository.findDayBookBusinessmenByBusinessman(businessmanInfo);
    }

    @Override
    public void save(DayBookBusinessman dayBookBusinessman) {
        dayBookBusinessmanRepository.save(dayBookBusinessman);
    }
}
