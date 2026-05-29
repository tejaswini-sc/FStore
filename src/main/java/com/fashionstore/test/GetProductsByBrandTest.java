package com.fashionstore.test;

import java.util.List;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

public class GetProductsByBrandTest {

    public static void main(String[] args) {

        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());

        // Brand ID = 1 (Nike)

        List<Product> list =
                dao.getProductsByBrand(1);

        for(Product p : list) {

            System.out.println(p.getProductName());
        }
    }
}