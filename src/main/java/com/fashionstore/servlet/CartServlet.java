package com.fashionstore.servlet;
import com.fashionstore.model.User;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.google.gson.Gson;
import com.fashionstore.daoimpl.CartDAOImpl;
import com.fashionstore.model.Cart;
import com.fashionstore.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

    	resp.setContentType("text/html");

    	PrintWriter out = resp.getWriter();

    	CartDAOImpl dao =
    	        new CartDAOImpl(DBConnection.getConnection());


    	// Action Parameter

    	String action =
    	        req.getParameter("action");


    	if(action != null &&
    	   action.equals("view")) {

    		HttpSession session =
    		        req.getSession(false);


    		if(session == null ||
    		   session.getAttribute("user") == null) {

    		    out.println("Please Login First");

    		    return;
    		}


    		// Get Logged User

    		User user =
    		        (User) session.getAttribute("user");


    		int userId =
    		        user.getUserId();

    	    List<Cart> list =
    	            dao.getCartByUser(userId);

    	    
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

    	CartDAOImpl dao =
    	        new CartDAOImpl(DBConnection.getConnection());


    	// Action Parameter

    	String action =
    	        req.getParameter("action");


    	// ADD TO CART

    	if(action.equals("add")) {

    	    Cart cart = new Cart();

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


    	    cart.setUserId(
    	            user.getUserId());

    	    cart.setProductId(
    	            Integer.parseInt(
    	                    req.getParameter("productId")));

    	    cart.setQuantity(
    	            Integer.parseInt(
    	                    req.getParameter("quantity")));

    	    
    	    boolean status =
    	            dao.addToCart(cart);

    	    
    	    if(status) {

    	        out.println("Added To Cart");

    	    } else {

    	        out.println("Failed");
    	    }
    	}


    	// UPDATE CART

    	else if(action.equals("update")) {

    	    int cartId =
    	            Integer.parseInt(
    	                    req.getParameter("cartId"));

    	    int quantity =
    	            Integer.parseInt(
    	                    req.getParameter("quantity"));

    	    
    	    boolean status =
    	            dao.updateCartQuantity(
    	                    cartId,
    	                    quantity);

    	    
    	    if(status) {

    	        out.println("Cart Updated");

    	    } else {

    	        out.println("Failed");
    	    }
    	}


    	// REMOVE ITEM

    	else if(action.equals("remove")) {

    	    int cartId =
    	            Integer.parseInt(
    	                    req.getParameter("cartId"));

    	    
    	    boolean status =
    	            dao.removeFromCart(cartId);

    	    
    	    if(status) {

    	        out.println("Removed Successfully");

    	    } else {

    	        out.println("Failed");
    	    }
    	}
    	
    	
    }
}