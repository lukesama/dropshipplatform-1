package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.entity.ProductPush;
import com.jnu.dropshipplatform.repository.ProductPushRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPushServiceImpl implements ProductPushService{

    @Autowired
    private ProductPushRepository productPushRepository;

    @Override
    public ProductPush insertProductPush(ProductPush productPush) {
        return productPushRepository.save(productPush);
    }

    @Override
    public Boolean existProductPush(BusinessmanInfo businessmanInfo, ProductInfo productInfo) {
        return productPushRepository.existsProductPushByBusiIdAndProId(businessmanInfo,productInfo);
    }

    @Override
    public ProductPush getProductPushByBusAndPro(BusinessmanInfo businessmanInfo, ProductInfo productInfo) {
        return productPushRepository.getByBusiIdAndProId(businessmanInfo,productInfo).get();
    }

    @Override
    public List<ProductPush> getAllPushProduct(BusinessmanInfo businessmanInfo) {
        return productPushRepository.findAllByBusiId(businessmanInfo);
    }

    @Override
    public void cancelProduct(Integer pushId) {
        productPushRepository.deleteById(pushId);
    }

    @Override
    public Boolean existProPushByProInfo(ProductInfo productInfo) {
        return productPushRepository.existsProductPushByProId(productInfo);
    }

    @Override
    public List<ProductPush> getAllProByProInfo(ProductInfo productInfo) {
        return productPushRepository.getProductPushesByProId(productInfo);
    }

    @Override
    public List<ProductPush> getAll() {
        return productPushRepository.findAll();
    }
}
