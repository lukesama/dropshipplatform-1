package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.Unpublish;

import java.util.List;

public interface UnpublishService {
    List<Unpublish> getUnpublishByBusInfo(BusinessmanInfo businessmanInfo);

    void deleteById(Integer id);

    Unpublish addUnpublish(Unpublish unpublish);
}
