package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.OrderAndProduct;
import com.jnu.dropshipplatform.entity.OrderDetailed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailedRepository extends JpaRepository<OrderDetailed,Integer> {
    @Query(value="select new com.jnu.dropshipplatform.entity.OrderAndProduct (" +
            "d.orderId," +
            "d.proId," +
            "d.sellPrice," +
            "d.proSales," +
            "d.proModel," +
            "p.proName) from OrderDetailed d , ProductInfo p where d.orderId =?1 and p.proId=d.proId")
    List<OrderAndProduct> getOrderAndProductByOrderId(Integer orderId);

    List<OrderDetailed> findOrderDetailedsByOrderId(Integer orderId);
    List<OrderDetailed> findOrderDetailedsByProId(Integer proId);
}
