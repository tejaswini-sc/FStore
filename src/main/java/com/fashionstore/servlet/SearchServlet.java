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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        String keyword =
                req.getParameter("keyword");

        
        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());

        
        List<Product> list =
                dao.searchProducts(keyword);

        
        resp.setContentType("application/json");

        
        Gson gson = new Gson();

        
        String json =
                gson.toJson(list);

        
        resp.getWriter().print(json);
    }
}