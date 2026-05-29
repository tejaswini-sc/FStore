package com.fashionstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.fashionstore.daoimpl.UserDAOImpl;
import com.fashionstore.model.User;
import com.fashionstore.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        // Get Login Data

        String email =
                req.getParameter("email");

        String password =
                req.getParameter("password");


        // DAO Object

        UserDAOImpl dao =
                new UserDAOImpl(DBConnection.getConnection());


        // Validate User

        User user =
                dao.loginUser(email, password);


        if(user != null) {

            HttpSession session =
                    req.getSession();

            session.setAttribute("user", user);

            out.print("Login Successful");

        }
        else {

            out.print("Invalid Login");

        }
    }
}