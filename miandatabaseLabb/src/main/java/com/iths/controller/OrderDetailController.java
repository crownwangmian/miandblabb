package com.iths.controller;


import com.iths.domain.pojo.OrderDetail;
import com.iths.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping
    public OrderDetail addOrderDetail(@RequestBody OrderDetail detail) {
        return orderDetailService.addOrderDetail(detail);
    }

    @PutMapping
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail detail) {
        return orderDetailService.updateOrderDetail(detail);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable int id) {
        orderDetailService.deleteOrderDetail(id);
    }

    @GetMapping("/{id}")
    public OrderDetail findOrderDetailById(@PathVariable int id) {
        return orderDetailService.findOrderDetailById(id);
    }

    @GetMapping
    public List<OrderDetail> findAllOrderDetails() {
        return orderDetailService.findAllOrderDetails();
    }

    @GetMapping("/order/{orderId}")
    public List<OrderDetail> findByOrderId(@PathVariable int orderId) {
        return orderDetailService.findByOrderId(orderId);
    }

    @GetMapping("/product/{productId}")
    public List<OrderDetail> findByProductId(@PathVariable int productId) {
        return orderDetailService.findByProductId(productId);
    }

}
