package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findProductCategoryByFatherId(Integer id);
}
