package com.iths.service;

import com.iths.domain.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail addOrderDetail(OrderDetail detail);

    OrderDetail updateOrderDetail(OrderDetail detail);

    void deleteOrderDetail(int id);

    OrderDetail findOrderDetailById(int id);

    List<OrderDetail> findAllOrderDetails();

    List<OrderDetail> findByOrderId(int orderId);

    List<OrderDetail> findByProductId(int productId);
}
