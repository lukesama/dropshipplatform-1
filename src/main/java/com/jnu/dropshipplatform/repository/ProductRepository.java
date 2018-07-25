package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductInfo,Integer> {
}
