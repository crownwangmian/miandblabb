package com.iths.DAO;

import com.iths.domain.pojo.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(int userId);

    Cart findByUserIdAndItemId(int userId, int itemId);

}
