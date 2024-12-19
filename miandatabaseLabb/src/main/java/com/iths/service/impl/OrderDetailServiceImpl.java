package com.iths.service.impl;

import com.iths.DAO.OrderDetailDAO;
import com.iths.domain.pojo.OrderDetail;
import com.iths.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Override
    public OrderDetail addOrderDetail(OrderDetail detail) {
        return orderDetailDAO.save(detail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail detail) {
        return orderDetailDAO.save(detail);
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailDAO.deleteById(id);
    }

    @Override
    public OrderDetail findOrderDetailById(int id) {
        return orderDetailDAO.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> findAllOrderDetails() {
        return orderDetailDAO.findAll();
    }

    @Override
    public List<OrderDetail> findByOrderId(int orderId) {
        return orderDetailDAO.findByOrderId(orderId);
    }

    @Override
    public List<OrderDetail> findByProductId(int productId) {
        return orderDetailDAO.findByProductId(productId);
    }

}
