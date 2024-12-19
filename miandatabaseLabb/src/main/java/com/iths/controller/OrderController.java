package com.iths.controller;


import com.iths.domain.dto.OrderRequestDTO;
import com.iths.domain.pojo.Order;
import com.iths.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequestDTO requestDTO) {
        return orderService.createOrder(requestDTO);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable int id) {
        return orderService.findOrderById(id);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<Order> findByUserId(@PathVariable int userId) {
        return orderService.findByUserId(userId);
    }

}
