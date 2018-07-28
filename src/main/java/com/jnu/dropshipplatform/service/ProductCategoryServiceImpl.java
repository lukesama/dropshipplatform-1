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
    public List<ProductCategory> getProCateByCateName(String category) {
        return productCategoryRepository.findProductCategoriesByCatePathLike(category);
    }

    @Override
    public List<ProductCategory> getCateByFatherId(Integer fatherId) {
        return productCategoryRepository.findProductCategoriesByFatherCateId(fatherId);
    }

    @Override
    public ProductCategory getCateInfoById(Integer cateId) {
        return productCategoryRepository.findById(cateId).get();
    }
//    @Override
//    public List<ProductCategory> getSubProductByFatherCateName(String cateName) {
//        ProductCategory proCate_temp = productCategoryRepository.findProductCategoryByCateName(cateName);
//        return productCategoryRepository.findProductCategorysByFatherCateId(proCate_temp.getCateId());
//    }

    @Override
    public Boolean isDetailProductByCateId(Integer cateId) {
        List<ProductCategory> detailProducts = productCategoryRepository.findProductCategoriesByCatePathLike(">%>%>%");
        for (int i=0;i<detailProducts.size();i++) {
            Integer CID = detailProducts.get(i).getCateId();
            if(CID == cateId){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ProductCategory> getAllProCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory addCatagory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
