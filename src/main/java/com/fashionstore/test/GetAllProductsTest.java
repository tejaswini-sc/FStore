package com.fashionstore.test;

import java.util.List;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

public class GetAllProductsTest {

    public static void main(String[] args) {

        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());

        List<Product> list = dao.getAllProducts();

        for(Product p : list) {

            System.out.println("ID : " + p.getProductId());

            System.out.println("Name : " + p.getProductName());

            System.out.println("Price : " + p.getPrice());

            System.out.println("Rating : " + p.getRating());

            System.out.println("---------------------");
        }
    }
}