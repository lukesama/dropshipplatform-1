package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductAndCategory;
import com.jnu.dropshipplatform.entity.ProductCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.repository.ProductCategoryRepository;
import com.jnu.dropshipplatform.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductAndCategory> getProductAndCategory(Integer productId) {
        return productInfoRepository.getProductAndCategory(productId);
    }

    @Override
    public void save(ProductInfo productInfo) {
        productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo findProductInfoByProId(Integer proId) {
        return productInfoRepository.findProductInfoByProId(proId);
    }

    @Override
    public List<ProductInfo> getProductByCateId(Integer cateId) {
        return productInfoRepository.findProductInfosByProCategoryId(cateId);
    }

    @Override
    public List<ProductInfo> getAllProduct() {
        return productInfoRepository.findAll();
    }

    @Override
    public void delete(Integer proId) {
        productInfoRepository.deleteById(proId);
    }

    @Override
    public List<ProductInfo> getProductByMidCate(Integer cateId) {
        int mainCount = productCategoryRepository.findProductCategoriesByFatherCateId(0).size();    //主类别个数
        List<ProductCategory> nextCategories = productCategoryRepository.findProductCategoriesByFatherCateId(cateId);
        if (nextCategories.size() == 0){
            //当所选类别是详细类别时，无需遍历子类别，直接返回
            return productInfoRepository.findProductInfosByProCategoryId(cateId);
        }
        List<ProductInfo> resultProductInfo = productInfoRepository.findProductInfosByProCategoryId(nextCategories.get(0).getCateId());
        for (int i = 1; i < nextCategories.size(); i++){
            resultProductInfo.addAll(productInfoRepository.findProductInfosByProCategoryId(nextCategories.get(i).getCateId()));
        }
        if (cateId <= mainCount){
            //当所选类别是主类别时进入
            List<ProductCategory> lastCategories = productCategoryRepository.findProductCategoriesByFatherCateId(nextCategories.get(0).getCateId());
            for (int i = 1; i < nextCategories.size(); i++){
                lastCategories.addAll(productCategoryRepository.findProductCategoriesByFatherCateId(nextCategories.get(i).getCateId()));
            }
            for (int i = 0; i < lastCategories.size(); i++){
                resultProductInfo.addAll(productInfoRepository.findProductInfosByProCategoryId(lastCategories.get(i).getCateId()));
            }
        }
        return resultProductInfo;
    }
}
