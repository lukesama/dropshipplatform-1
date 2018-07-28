package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.OrderAndProduct;
import com.jnu.dropshipplatform.entity.OrderDetailed;

import java.util.List;

public interface OrderDetailedService {
    List<OrderDetailed> findAllByProId(Integer proId);
    List<OrderDetailed> findAllByOrderId(Integer orderId);
    List<OrderAndProduct> getOrderAndProductByOrderId(Integer orderId);

}
