package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandProduct;

import java.util.List;

public interface BrandProductService {
    List<BrandProduct> findBrandProductByBrandId(Integer brandId);
    void save(BrandProduct brandProduct);
    void deleteByProId(Integer proId);
}
