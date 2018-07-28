package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductAndCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductAndCategory> getProductAndCategory(Integer productId);
    void save(ProductInfo productInfo);
    ProductInfo findProductInfoByProId(Integer proId);

    List<ProductInfo> getProductByCateId(Integer cateId);

    List<ProductInfo> getAllProduct();

    //根据中间类别（主类别、次类别）搜索商品
    List<ProductInfo> getProductByMidCate(Integer cateId);

    void delete(Integer proId);

    Boolean keyInProductTitle(Integer productId,String key);
}
