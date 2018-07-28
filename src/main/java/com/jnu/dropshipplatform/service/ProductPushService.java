package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.entity.ProductPush;

import java.util.List;
import java.util.Optional;

public interface ProductPushService {

    ProductPush insertProductPush(ProductPush productPush);

    Boolean existProductPush(BusinessmanInfo businessmanInfo, ProductInfo productInfo);

    ProductPush getProductPushByBusAndPro(BusinessmanInfo businessmanInfo, ProductInfo productInfo);

    List<ProductPush> getAllPushProduct(BusinessmanInfo businessmanInfo);

    void cancelProduct(Integer pushId);

    Boolean existProPushByProInfo(ProductInfo productInfo);

    List<ProductPush> getAllProByProInfo(ProductInfo productInfo);
}
