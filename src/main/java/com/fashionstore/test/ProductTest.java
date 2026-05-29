package com.fashionstore.test;

import com.fashionstore.daoimpl.ProductDAOImpl;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

public class ProductTest {

    public static void main(String[] args) {

        Product product = new Product();

        product.setProductName("Nike Air Max");
        product.setDescription("Running Shoes");
        product.setPrice(4999);
        product.setStock(10);
        product.setImageUrl("nike.jpg");
        product.setRating(4.5);

        // Existing IDs from database
        product.setBrandId(1);
        product.setCategoryId(1);


        ProductDAOImpl dao =
                new ProductDAOImpl(DBConnection.getConnection());


        boolean status = dao.addProduct(product);


        if(status) {

            System.out.println("Product Added Successfully");

        } else {

            System.out.println("Failed");
        }
    }
}