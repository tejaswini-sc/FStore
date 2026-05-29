package com.fashionstore.daoimpl;

import java.sql.Connection;

import com.fashionstore.dao.UserDAO;
import com.fashionstore.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    private Connection con;

    
    // Constructor
    public UserDAOImpl(Connection con) {

        this.con = con;
    }

    
    @Override
    public boolean registerUser(User user) {

        boolean status = false;

        try {

            String query = "INSERT INTO users(name,email,password,phone,address) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    
    @Override
    public User loginUser(String email, String password) {

        User user = null;

        try {

            String query = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }

}