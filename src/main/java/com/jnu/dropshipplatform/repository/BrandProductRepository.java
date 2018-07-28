package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandProductRepository extends JpaRepository<BrandProduct,Integer> {
    List<BrandProduct> findBrandProductByBrandId(Integer brandId);
    @Query(value="delete from BrandProduct b where b.productInfo=?1")
    void deleteProductWithProId(Integer proId);
    List<BrandProduct> findBrandProductByProductInfo(Integer proId);
}
