package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.ProductCategory;
import javafx.beans.property.ListProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findProductCategoriesByCatePathLike(String category);

    List<ProductCategory> findProductCategoriesByFatherCateId(Integer fatherCateId);

//    ProductCategory findProductCategoryByCateName(String cateName);

}
