package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandProductRepository extends JpaRepository<BrandProduct,Integer> {
    List<BrandProduct> findBrandProductByBrandId(Integer brandId);
}
