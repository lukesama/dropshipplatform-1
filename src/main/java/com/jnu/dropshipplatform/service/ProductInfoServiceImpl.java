package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductAndCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductAndCategory> getProductAndCategory(Integer productId) {
        return productInfoRepository.getProductAndCategory(productId);
    }

    @Override
    public void save(ProductInfo productInfo) {
        productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo findProductInfoByProId(Integer proId) {
        return productInfoRepository.findProductInfoByProId(proId);
    }

    @Override
    public void delete(Integer proId) {
        productInfoRepository.deleteById(proId);
    }
}
