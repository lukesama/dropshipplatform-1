package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.DataDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryRepository dataDictionaryRepository;
}
