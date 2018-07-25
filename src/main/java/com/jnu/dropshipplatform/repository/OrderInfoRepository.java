package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {
}
