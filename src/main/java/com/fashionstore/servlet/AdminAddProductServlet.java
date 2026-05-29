package com.fashionstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/add-product")
public class AdminAddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        resp.setContentType("application/json");

        PrintWriter out =
                resp.getWriter();


        Product product =
                new Product();


        product.setProductName(
                req.getParameter("productName"));

        product.setDescription(
                req.getParameter("description"));

        product.setPrice(
                Double.parseDouble(
                        req.getParameter("price")));

        product.setStock(
                Integer.parseInt(
                        req.getParameter("stock")));

        product.setImageUrl(
                req.getParameter("imageUrl"));

        product.setRating(
                Double.parseDouble(
                        req.getParameter("rating")));

        product.setBrandId(
                Integer.parseInt(
                        req.getParameter("brandId")));

        product.setCategoryId(
                Integer.parseInt(
                        req.getParameter("categoryId")));


        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());


        boolean status =
                dao.addProduct(product);


        if(status) {

            out.println(
                    "{\"message\":\"Product Added Successfully\"}");

        } else {

            out.println(
                    "{\"message\":\"Failed To Add Product\"}");
        }
    }
}