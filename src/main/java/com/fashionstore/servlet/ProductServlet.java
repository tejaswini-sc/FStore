
package com.fashionstore.servlet;

import java.io.IOException;
import java.util.List;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setContentType("application/json");

        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());

        
        // Get Parameter
        String category =
                req.getParameter("category");


        List<Product> list;


        // Category Filter
        if(category != null &&
           !category.equals("null")) {

            int categoryId =
                    Integer.parseInt(category);

            list =
                    dao.getProductsByCategory(categoryId);

        }

        // All Products
        else {

            list =
                    dao.getAllProducts();
        }


        // Convert To JSON
        Gson gson =
                new Gson();

        String json =
                gson.toJson(list);


        // Send Response
        resp.getWriter().print(json);
    }
}

