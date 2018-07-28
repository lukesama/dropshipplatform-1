package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandProduct;
import com.jnu.dropshipplatform.repository.BrandProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandProductServiceImpl implements BrandProductService{

    @Autowired
    private BrandProductRepository brandProductRepository;

    @Override
    public List<BrandProduct> findBrandProductByBrandId(Integer brandId) {
        return brandProductRepository.findBrandProductByBrandId(brandId);
    }

    @Override
    public void save(BrandProduct brandProduct) {
         brandProductRepository.save(brandProduct);
    }

    @Override
    public void deleteByProId(Integer proId) {
        brandProductRepository.deleteProductWithProId(proId);
    }

    @Override
    public List<BrandProduct> findBrandProductByProduct(Integer proId) {
        return brandProductRepository.findBrandProductByProductInfo(proId);
    }
}
