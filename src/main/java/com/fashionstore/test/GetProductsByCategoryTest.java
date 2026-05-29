package com.fashionstore.test;

import java.util.List;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

public class GetProductsByCategoryTest {

    public static void main(String[] args) {

        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());

        // Category ID = 1 (Shoes)

        List<Product> list =
                dao.getProductsByCategory(1);

        for(Product p : list) {

            System.out.println(p.getProductName());
        }
    }
}