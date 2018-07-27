package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.DayBookBusinessman;

import java.util.List;

public interface DayBookBusinessmanService {
    List<DayBookBusinessman> findDaybookByBussinessman(BusinessmanInfo businessmanInfo);
    void save(DayBookBusinessman dayBookBusinessman);

    List<DayBookBusinessman> getAllDayBookBusinessman();

    DayBookBusinessman findDayBookBusinessmanById(Integer ID);
}
