package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.Unpublish;
import com.jnu.dropshipplatform.repository.UnpublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnpublishServiceImpl implements UnpublishService{
    @Autowired
    private UnpublishRepository unpublishRepository;

    @Override
    public List<Unpublish> getUnpublishByBusInfo(BusinessmanInfo businessmanInfo) {
        return unpublishRepository.findUnpublishesByBusinessmanInfo(businessmanInfo);
    }

    @Override
    public void deleteById(Integer id) {
        unpublishRepository.deleteById(id);
    }

    @Override
    public Unpublish addUnpublish(Unpublish unpublish) {
        return unpublishRepository.save(unpublish);
    }
}
