package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductAndCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductAndCategory> getProductAndCategory(Integer productId);
    void save(ProductInfo productInfo);
    ProductInfo findProductInfoByProId(Integer proId);
    void delete(Integer proId);
}
