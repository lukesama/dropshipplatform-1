package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.BrandProduct;
import com.jnu.dropshipplatform.entity.ProductCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.repository.BrandProductRepository;
import com.jnu.dropshipplatform.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandProductServiceImpl implements BrandProductService{

    @Autowired
    private BrandProductRepository brandProductRepository;
//    @Autowired
//    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductInfoService productInfoService;

    @Override
    public List<BrandProduct> findBrandProductByBrandId(Integer brandId) {
        return brandProductRepository.findBrandProductByBrandId(brandId);
    }

    @Override
    public void save(BrandProduct brandProduct) {
         brandProductRepository.save(brandProduct);
    }

    @Override
    public void deleteByProId(Integer proId) {
        brandProductRepository.deleteProductWithProId(proId);
    }

    @Override
    public List<BrandProduct> findBrandProductByProduct(Integer proId) {
        return brandProductRepository.findBrandProductByProductInfo(proId);
    }

    @Override
    public Boolean inBrandProduct(Integer productId,Integer brandId) {
        return brandProductRepository.existsBrandProductByProductInfoAndBrandId(productId,brandId);
    }

    @Override
    public BrandProduct getBrandProductByProductId(Integer productId) {
        return brandProductRepository.getBrandProductByProductInfo(productId);
    }

}
