package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductCategory;
import com.jnu.dropshipplatform.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findProductCategoryByFatherId(Integer id) {
        return productCategoryRepository.findProductCategoriesByFatherCateId(id);
    }
}
