package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.OrderDetailed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailedRepository extends JpaRepository<OrderDetailed,Integer> {
    List<OrderDetailed> findOrderDetailedsByOrderId(Integer orderId);
    List<OrderDetailed> findOrderDetailedsByProId(Integer proId);
}
