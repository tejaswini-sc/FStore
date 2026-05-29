package com.fashionstore.test;

import com.fashionstore.daoimpl.CartDAOImpl;
import com.fashionstore.model.Cart;
import com.fashionstore.util.DBConnection;

public class AddCartTest {

    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.setUserId(1);

        cart.setProductId(1);

        cart.setQuantity(2);


        CartDAOImpl dao =
                new CartDAOImpl(DBConnection.getConnection());


        boolean status =
                dao.addToCart(cart);


        if(status) {

            System.out.println("Added To Cart");

        } else {

            System.out.println("Failed");
        }
    }
}