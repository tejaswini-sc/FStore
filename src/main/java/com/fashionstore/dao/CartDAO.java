package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Cart;

public interface CartDAO {

    // Add To Cart
    boolean addToCart(Cart cart);

    
    // Update Quantity
    boolean updateCartQuantity(int cartId, int quantity);

    
    // Remove Cart Item
    boolean removeFromCart(int cartId);

    
    // Get User Cart
    List<Cart> getCartByUser(int userId);

}