package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.OrderAndProduct;
import com.jnu.dropshipplatform.entity.OrderDetailed;
import com.jnu.dropshipplatform.repository.OrderDetailedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailedServiceImpl implements OrderDetailedService{
    @Autowired
    private OrderDetailedRepository orderDetailedRepository;

    @Override
    public List<OrderDetailed> findAllByProId(Integer proId) {
        return orderDetailedRepository.findOrderDetailedsByProId(proId);
    }

    @Override
    public List<OrderDetailed> findAllByOrderId(Integer orderId) {
        return orderDetailedRepository.findOrderDetailedsByOrderId(orderId);
    }

    @Override
    public List<OrderAndProduct> getOrderAndProductByOrderId(Integer orderId) {
        return orderDetailedRepository.getOrderAndProductByOrderId(orderId);
    }
}
