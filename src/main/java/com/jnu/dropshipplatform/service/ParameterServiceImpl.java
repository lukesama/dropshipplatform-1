package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService{

    @Autowired
    private ParameterRepository parameterRepository;
}
