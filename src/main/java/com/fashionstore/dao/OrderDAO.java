package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Order;

public interface OrderDAO {

    // Place Order
    boolean placeOrder(Order order);

    
    // View Orders By User
    List<Order> getOrdersByUser(int userId);
}