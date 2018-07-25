package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.ProductPushRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPushServiceImpl implements ProductPushService{

    @Autowired
    private ProductPushRepository productPushRepository;
}
