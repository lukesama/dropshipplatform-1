package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> findOrderInfoByBussinessman(BusinessmanInfo businessmanInfo ,Integer orderStatus);
    OrderInfo findOrderInfoByOrderId(Integer orderId);
    void save(OrderInfo orderInfo);
}
