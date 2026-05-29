package com.fashionstore.servlet;

import java.io.IOException;

import com.fashionstore.daoimpl.UserDAOImpl;
import com.fashionstore.model.User;
import com.fashionstore.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        // Get Form Data

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");


        // Store Data into User Object

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setAddress(address);


        // DAO Object

        UserDAOImpl dao =
                new UserDAOImpl(DBConnection.getConnection());


        // Register User

        boolean status = dao.registerUser(user);


        if(status) {

            resp.getWriter().println("Registration Successful");

        } else {

            resp.getWriter().println("Registration Failed");
        }
    }
}