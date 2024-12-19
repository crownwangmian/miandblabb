package com.iths.DAO;

import com.iths.domain.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrderId(int orderId);  // Find order details by order ID

    List<OrderDetail> findByProductId(int productId);  // Find order details by product ID
}
