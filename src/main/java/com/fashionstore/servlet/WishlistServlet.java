package com.fashionstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.google.gson.Gson;

import com.fashionstore.daoimpl.WishlistDAOImpl;
import com.fashionstore.model.User;
import com.fashionstore.model.Wishlist;
import com.fashionstore.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        // Session Check

        HttpSession session =
                req.getSession(false);


        if(session == null ||
           session.getAttribute("user") == null) {

            out.println("Please Login First");

            return;
        }


        // Logged User

        User user =
                (User) session.getAttribute("user");


        int userId =
                user.getUserId();


        WishlistDAOImpl dao =
                new WishlistDAOImpl(DBConnection.getConnection());


        String action =
                req.getParameter("action");


        // VIEW WISHLIST

        if(action != null &&
           action.equals("view")) {

            List<Wishlist> list =
                    dao.getWishlistByUser(userId);


            resp.setContentType("application/json");

            Gson gson = new Gson();

            String json =
                    gson.toJson(list);

            resp.getWriter().print(json);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        // Session Check

        HttpSession session =
                req.getSession(false);


        if(session == null ||
           session.getAttribute("user") == null) {

            out.println("Please Login First");

            return;
        }


        // Logged User

        User user =
                (User) session.getAttribute("user");


        int userId =
                user.getUserId();


        WishlistDAOImpl dao =
                new WishlistDAOImpl(DBConnection.getConnection());


        String action =
                req.getParameter("action");


        // ADD TO WISHLIST

        if(action.equals("add")) {

            Wishlist wishlist =
                    new Wishlist();

            wishlist.setUserId(userId);

            wishlist.setProductId(
                    Integer.parseInt(
                            req.getParameter("productId")));


            boolean status =
                    dao.addToWishlist(wishlist);


            if(status) {

                out.println("Added To Wishlist");

            } else {

                out.println("Failed");
            }
        }


        // REMOVE WISHLIST

        else if(action.equals("remove")) {

            int wishlistId =
                    Integer.parseInt(
                            req.getParameter("wishlistId"));


            boolean status =
                    dao.removeFromWishlist(wishlistId);


            if(status) {

                out.println("Removed Successfully");

            } else {

                out.println("Failed");
            }
        }
    }
}