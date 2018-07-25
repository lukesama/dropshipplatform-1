package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.repository.BrandProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandProductServiceImpl implements BrandProductService{

    @Autowired
    private BrandProductRepository brandProductRepository;
}
