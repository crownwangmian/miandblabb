package com.iths.service;

import com.iths.domain.dto.OrderRequestDTO;
import com.iths.domain.pojo.Order;
import com.iths.domain.pojo.Product;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequestDTO requestDTO);

    Order updateOrder(Order order);

    void deleteOrder(int id);

    Order findOrderById(int id);

    List<Order> findAllOrders();

    List<Order> findByUserId(int userId);


}
