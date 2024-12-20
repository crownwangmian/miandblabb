package com.iths.service;

import com.iths.domain.pojo.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartItems(int userId);

    Cart addItemToCart(int userId, int itemId, int quantity, double price);

    void removeItemFromCart(int userId, int itemId);

    void clearCart(int userId);
}
