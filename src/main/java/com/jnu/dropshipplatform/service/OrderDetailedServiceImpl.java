package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.OrderDetailedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailedServiceImpl implements OrderDetailedService{
    @Autowired
    private OrderDetailedRepository orderDetailedRepository;
}
