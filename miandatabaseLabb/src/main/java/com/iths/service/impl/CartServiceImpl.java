package com.iths.service.impl;

import com.iths.DAO.CartDAO;
import com.iths.domain.pojo.Cart;
import com.iths.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<Cart> getCartItems(int userId) {
        return cartDAO.findByUserId(userId);
    }

    @Override
    public Cart addItemToCart(int userId, int itemId, int quantity, double price) {
        Cart cart = cartDAO.findByUserIdAndItemId(userId, itemId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setItemId(itemId);
            cart.setQuantity(quantity);
            cart.setPrice(price);
        } else {
            cart.setQuantity(cart.getQuantity() + quantity);
        }
        return cartDAO.save(cart);
    }

    @Override
    public void removeItemFromCart(int userId, int itemId) {
        Cart cart = cartDAO.findByUserIdAndItemId(userId, itemId);
        if (cart != null) {
            cartDAO.delete(cart);
        }
    }

    @Override
    public void clearCart(int userId) {
        List<Cart> cartItems = cartDAO.findByUserId(userId);
        cartDAO.deleteAll(cartItems);
    }
}
