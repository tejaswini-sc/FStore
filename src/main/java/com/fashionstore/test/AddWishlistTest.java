package com.fashionstore.test;

import com.fashionstore.daoimpl.WishlistDAOImpl;
import com.fashionstore.model.Wishlist;
import com.fashionstore.util.DBConnection;

public class AddWishlistTest {

    public static void main(String[] args) {

        Wishlist wishlist = new Wishlist();

        // Existing user ID
        wishlist.setUserId(1);

        // Existing product ID
        wishlist.setProductId(1);


        WishlistDAOImpl dao =
                new WishlistDAOImpl(DBConnection.getConnection());


        boolean status =
                dao.addToWishlist(wishlist);


        if(status) {

            System.out.println("Added To Wishlist");

        } else {

            System.out.println("Failed");
        }
    }
}