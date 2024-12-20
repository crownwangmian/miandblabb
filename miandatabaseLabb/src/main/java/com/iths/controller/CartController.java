package com.iths.controller;

import com.iths.domain.dto.CartRequestDTO;
import com.iths.domain.pojo.Cart;
import com.iths.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/{userId}")
    public List<Cart> getCartItems(@PathVariable int userId) {
        return cartService.getCartItems(userId);
    }

    @PostMapping("/add")
    public Cart addItemToCart(@RequestBody CartRequestDTO cartRequest) {
        return cartService.addItemToCart(
                cartRequest.getUserId(),
                cartRequest.getItemId(),
                cartRequest.getQuantity(),
                cartRequest.getPrice()
        );
    }

    @DeleteMapping("/remove")
    public void removeItemFromCart(@RequestParam int userId, @RequestParam int itemId) {
        cartService.removeItemFromCart(userId, itemId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
    }
}
