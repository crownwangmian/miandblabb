package com.iths.DAO;

import com.iths.domain.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int userId);  // Find orders by user ID
}
