package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.Unpublish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnpublishRepository extends JpaRepository<Unpublish,Integer> {
    List<Unpublish> findUnpublishesByBusinessmanInfo(BusinessmanInfo businessmanInfo);
}
