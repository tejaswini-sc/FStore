package com.fashionstore.servlet;

import java.io.IOException;
import java.util.List;

import com.fashionstore.daoimpl.OrderDAOImpl;
import com.fashionstore.model.Order;
import com.fashionstore.model.User;
import com.fashionstore.util.DBConnection;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setContentType("application/json");


        // Session Check

        HttpSession session =
                req.getSession(false);


        if(session == null ||
           session.getAttribute("user") == null) {

            resp.getWriter()
                .print("{\"message\":\"Please Login First\"}");

            return;
        }


        // Logged User

        User user =
                (User) session.getAttribute("user");


        int userId =
                user.getUserId();


        OrderDAOImpl dao =
                new OrderDAOImpl(DBConnection.getConnection());


        List<Order> list =
                dao.getOrdersByUser(userId);


        Gson gson =
                new Gson();


        String json =
                gson.toJson(list);


        resp.getWriter().print(json);
    }


    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        resp.setContentType("application/json");


        // Session Check

        HttpSession session =
                req.getSession(false);


        if(session == null ||
           session.getAttribute("user") == null) {

            resp.getWriter()
                .print("{\"message\":\"Please Login First\"}");

            return;
        }


        // Logged User

        User user =
                (User) session.getAttribute("user");


        int userId =
                user.getUserId();


        Order order =
                new Order();


        order.setUserId(userId);

        order.setTotalAmount(
                Double.parseDouble(
                        req.getParameter("totalAmount")));

        order.setStatus("Placed");


        OrderDAOImpl dao =
                new OrderDAOImpl(DBConnection.getConnection());


        boolean status =
                dao.placeOrder(order);


        if(status) {

            resp.getWriter()
                .print("{\"message\":\"Order Placed Successfully\"}");

        } else {

            resp.getWriter()
                .print("{\"message\":\"Failed To Place Order\"}");
        }
    }
}