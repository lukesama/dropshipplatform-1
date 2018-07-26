package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    //根据类别名查找出该类别所属的最详细的类别信息
    List<ProductCategory> getProCateByCateName(String category);

    //根据父类别ID查找出属于该类别的所有类别信息
    List<ProductCategory> getCateByFatherId(Integer fatherId);

//    //
//    List<ProductCategory> getDetailedCate(Integer main);

//    //根据主类别名查找出属于该主类别的所有次类别信息
//    List<ProductCategory> getSubProductByFatherCateName(String cateName);
}
