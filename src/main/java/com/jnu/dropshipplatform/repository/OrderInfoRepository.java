package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.OrderInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {
    List<OrderInfo> findOrderInfosByBusiIdAndOrderStatus(BusinessmanInfo businessmanInfo,Integer orderStatus);
    OrderInfo findOrderInfosByOrderId(Integer orderId);
}
