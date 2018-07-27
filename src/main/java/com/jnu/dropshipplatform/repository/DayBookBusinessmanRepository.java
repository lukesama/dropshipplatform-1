package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.DayBookBusinessman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayBookBusinessmanRepository extends JpaRepository<DayBookBusinessman,Integer> {
    List<DayBookBusinessman> findDayBookBusinessmenByBusinessman(BusinessmanInfo businessmanInfo);
}
