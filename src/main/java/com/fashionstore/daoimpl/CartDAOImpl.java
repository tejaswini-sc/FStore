package com.fashionstore.daoimpl;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.fashionstore.dao.CartDAO;
import com.fashionstore.model.Cart;

public class CartDAOImpl implements CartDAO {

    private Connection con;

    
    public CartDAOImpl(Connection con) {

        this.con = con;
    }

    
    @Override
    public boolean addToCart(Cart cart) {

        boolean status = false;

        try {

            String query =
                    "INSERT INTO cart(user_id,product_id,quantity) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, cart.getUserId());

            ps.setInt(2, cart.getProductId());

            ps.setInt(3, cart.getQuantity());

            int rows = ps.executeUpdate();

            System.out.println("Rows Inserted : " + rows);

            if(rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    
    @Override
    public boolean updateCartQuantity(int cartId, int quantity) {

        boolean status = false;

        try {

            String query =
                    "UPDATE cart SET quantity=? WHERE cart_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, quantity);

            ps.setInt(2, cartId);

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
    public boolean removeFromCart(int cartId) {

        boolean status = false;

        try {

            String query =
                    "DELETE FROM cart WHERE cart_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, cartId);

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
    public List<Cart> getCartByUser(int userId) {

        List<Cart> list = new ArrayList<>();

        try {

            String query =
                    "SELECT * FROM cart WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Cart cart = new Cart();

                cart.setCartId(
                        rs.getInt("cart_id"));

                cart.setUserId(
                        rs.getInt("user_id"));

                cart.setProductId(
                        rs.getInt("product_id"));

                cart.setQuantity(
                        rs.getInt("quantity"));

                list.add(cart);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

}