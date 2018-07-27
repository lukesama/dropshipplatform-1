package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findProductCategoriesByFatherCateId(Integer id);
}
