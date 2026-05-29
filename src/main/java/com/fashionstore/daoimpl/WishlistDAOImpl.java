package com.fashionstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.WishlistDAO;
import com.fashionstore.model.Wishlist;

public class WishlistDAOImpl implements WishlistDAO {

    private Connection con;

    
    public WishlistDAOImpl(Connection con) {

        this.con = con;
    }

    
    @Override
    public boolean addToWishlist(Wishlist wishlist) {

        boolean status = false;

        try {

            String query =
                    "INSERT INTO wishlist(user_id,product_id) VALUES(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, wishlist.getUserId());

            ps.setInt(2, wishlist.getProductId());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    
    @Override
    public boolean removeFromWishlist(int wishlistId) {

        boolean status = false;

        try {

            String query =
                    "DELETE FROM wishlist WHERE wishlist_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, wishlistId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    
    @Override
    public List<Wishlist> getWishlistByUser(int userId) {

        List<Wishlist> list = new ArrayList<>();

        try {

            String query =
                    "SELECT * FROM wishlist WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Wishlist wishlist = new Wishlist();

                wishlist.setWishlistId(
                        rs.getInt("wishlist_id"));

                wishlist.setUserId(
                        rs.getInt("user_id"));

                wishlist.setProductId(
                        rs.getInt("product_id"));

                list.add(wishlist);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

}