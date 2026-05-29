package com.fashionstore.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

import com.fashionstore.dao.OrderDAO;
import com.fashionstore.model.Order;

public class OrderDAOImpl implements OrderDAO {

    private Connection con;


    public OrderDAOImpl(Connection con) {

        this.con = con;
    }


    @Override
    public boolean placeOrder(Order order) {

        boolean status = false;

        try {

            String query =
                    "INSERT INTO orders(user_id,total_amount,status) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, order.getUserId());

            ps.setDouble(2, order.getTotalAmount());

            ps.setString(3, order.getStatus());

            int rows =
                    ps.executeUpdate();

            
            if(rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<Order> getOrdersByUser(int userId) {

        List<Order> list =
                new ArrayList<>();

        try {

            String query =
                    "SELECT * FROM orders WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            
            while(rs.next()) {

                Order order =
                        new Order();

                order.setOrderId(
                        rs.getInt("order_id"));

                order.setUserId(
                        rs.getInt("user_id"));

                order.setTotalAmount(
                        rs.getDouble("total_amount"));

                order.setOrderDate(
                        rs.getString("order_date"));

                order.setStatus(
                        rs.getString("status"));

                
                list.add(order);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}