package com.fashionstore.test;

import java.util.List;

import com.fashionstore.daoimpl.WishlistDAOImpl;
import com.fashionstore.model.Wishlist;
import com.fashionstore.util.DBConnection;

public class GetWishlistTest {

    public static void main(String[] args) {

        WishlistDAOImpl dao =
                new WishlistDAOImpl(DBConnection.getConnection());

        List<Wishlist> list =
                dao.getWishlistByUser(1);

        for(Wishlist w : list) {

            System.out.println(
                    "Wishlist ID : " +
                    w.getWishlistId());

            System.out.println(
                    "User ID : " +
                    w.getUserId());

            System.out.println(
                    "Product ID : " +
                    w.getProductId());

            System.out.println("----------------");
        }
    }
}