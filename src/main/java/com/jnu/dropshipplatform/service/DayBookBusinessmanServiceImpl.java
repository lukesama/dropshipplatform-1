package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.DayBookBusinessmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayBookBusinessmanServiceImpl implements DayBookBusinessmanService {

    @Autowired
    private DayBookBusinessmanRepository dayBookBusinessmanRepository;

}
