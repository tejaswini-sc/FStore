package com.fashionstore.test;

import com.fashionstore.daoimpl.WishlistDAOImpl;
import com.fashionstore.util.DBConnection;

public class RemoveWishlistTest {

    public static void main(String[] args) {

        WishlistDAOImpl dao =
                new WishlistDAOImpl(DBConnection.getConnection());

        boolean status =
                dao.removeFromWishlist(1);

        if(status) {

            System.out.println("Removed Successfully");

        } else {

            System.out.println("Failed");
        }
    }
}