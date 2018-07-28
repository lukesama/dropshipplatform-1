package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.BrandProduct;
import com.jnu.dropshipplatform.entity.ProductInfo;

import java.util.List;

public interface BrandProductService {
    List<BrandProduct> findBrandProductByBrandId(Integer brandId);
    void save(BrandProduct brandProduct);
    void deleteByProId(Integer proId);
    //根据类别返回产品信息
    Boolean inBrandProduct(Integer productId);
    BrandProduct getBrandProductByProductId(Integer productId);
}
