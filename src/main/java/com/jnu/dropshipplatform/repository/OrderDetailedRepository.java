package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.OrderDetailed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailedRepository extends JpaRepository<OrderDetailed,Integer> {
}
