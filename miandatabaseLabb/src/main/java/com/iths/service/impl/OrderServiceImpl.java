package com.iths.service.impl;

import com.iths.DAO.OrderDAO;
import com.iths.DAO.OrderDetailDAO;
import com.iths.DAO.ProductDAO;
import com.iths.domain.dto.OrderRequestDTO;
import com.iths.domain.pojo.Order;
import com.iths.domain.pojo.OrderDetail;
import com.iths.domain.pojo.Product;
import com.iths.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Order createOrder(OrderRequestDTO requestDTO) {

        Order order = new Order();
        order.setUserId(requestDTO.getUserId());
        order.setTotalFee(0.0);
        Order savedOrder = orderDAO.save(order);

        double totalFee = 0.0;
        for (OrderRequestDTO.OrderDetail orderDetail : requestDTO.getOrderDetails()) {

            Product product = productDAO.findById(orderDetail.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            double productTotalFee = product.getPrice() * orderDetail.getQuantity();
            totalFee += productTotalFee;

            OrderDetail newOrderDetail = new OrderDetail();
            newOrderDetail.setOrderId(savedOrder.getId());
            newOrderDetail.setProductId(product.getId());
            newOrderDetail.setQuantity(orderDetail.getQuantity());

            orderDetailDAO.save(newOrderDetail);
        }

        // Update the order total fee
        savedOrder.setTotalFee(totalFee);
        return orderDAO.save(savedOrder);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderDAO.deleteById(id);
    }

    @Override
    public Order findOrderById(int id) {
        return orderDAO.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findByUserId(int userId) {
        return orderDAO.findByUserId(userId);
    }

}
