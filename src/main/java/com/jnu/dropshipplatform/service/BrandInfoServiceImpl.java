package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.repository.BrandInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandInfoServiceImpl implements BrandInfoService {

    @Autowired
    private BrandInfoRepository brandInfoRepository;

    @Override
    public BrandInfo addBrandInfo(BrandInfo brandInfo) {
        return brandInfoRepository.save(brandInfo);
    }

    @Override
    public void deleteBrandInfo(Integer brandId) {
        brandInfoRepository.deleteById(brandId);
    }

    @Override
    public BrandInfo updateBrandInfo(BrandInfo brandInfo) {
        return brandInfoRepository.save(brandInfo);
    }

    @Override
    public BrandInfo getBrandInfoByBrandId(Integer brandId) {
        return brandInfoRepository.findById(brandId).get();
    }

    @Override
    public List<BrandInfo> getAllBrand(Integer brandOwnerId) {
        return brandInfoRepository.findBrandInfoByBrandOwner_UserComId(brandOwnerId);
    }

}
