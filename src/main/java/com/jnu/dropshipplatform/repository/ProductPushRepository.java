package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.entity.ProductPush;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductPushRepository extends JpaRepository<ProductPush,Integer> {

    Boolean existsProductPushByBusiIdAndProId(BusinessmanInfo businessmanInfo, ProductInfo productInfo);

    Optional<ProductPush> getByBusiIdAndProId(BusinessmanInfo businessmanInfo, ProductInfo productInfo);

    List<ProductPush> findAllByBusiId(BusinessmanInfo businessmanInfo);

}
