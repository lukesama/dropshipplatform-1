package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.ProductAndCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
    @Query(value = "select new com.jnu.dropshipplatform.entity.ProductAndCategory( " +
            "p.proId," +
            "p.proName," +
            "p.proTitle," +
            "p.proCategoryId," +
            "p.droPrice," +
            "p.proStock," +
            "p.proModel," +
            "p.proImage , c.cateName ,b.brandName )  from ProductInfo p , ProductCategory c ,BrandInfo b " +
            "where p.proId=?1 and p.proCategoryId = c.cateId " +
            "and b.brandId=(select b.brandId from BrandProduct b where b.productInfo=?1)")
     List<ProductAndCategory> getProductAndCategory(Integer proid) ;
    ProductInfo findProductInfoByProId(Integer proId);

    //根据商品类别ID查找对应的商品信息
    List<ProductInfo> findProductInfosByProCategoryId(Integer cateId);


}
