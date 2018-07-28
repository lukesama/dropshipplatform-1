package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.OrderInfo;
import com.jnu.dropshipplatform.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public List<OrderInfo> findOrderInfoByBussinessman(BusinessmanInfo businessmanInfo,Integer orderStatus) {
        return orderInfoRepository.findOrderInfosByBusiIdAndOrderStatus(businessmanInfo,orderStatus);
    }

    @Override
    public OrderInfo findOrderInfoByOrderId(Integer orderId) {
        return orderInfoRepository.findOrderInfosByOrderId(orderId);
    }

    @Override
    public void save(OrderInfo orderInfo) {
        orderInfoRepository.save(orderInfo);
    }
}
