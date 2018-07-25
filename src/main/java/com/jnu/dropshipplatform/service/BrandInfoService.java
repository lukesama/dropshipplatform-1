package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;

import java.util.List;

public interface BrandInfoService {

    //Add
    BrandInfo addBrandInfo(BrandInfo brandInfo);

    //Delete
    void deleteBrandInfo(Integer brandId);

    //Update
    BrandInfo updateBrandInfo(BrandInfo brandInfo);

    //Select
    BrandInfo getBrandInfoByBrandId(Integer brandId);
    List<BrandInfo> getAllBrand(Integer brandOwnerId);

}
