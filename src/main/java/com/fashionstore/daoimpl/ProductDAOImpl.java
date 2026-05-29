package com.fashionstore.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.util.List;
import java.util.*;
import com.fashionstore.dao.ProductDAO;
import com.fashionstore.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private Connection con;

    
    // Constructor
    public ProductDAOImpl(Connection con) {

        this.con = con;
    }

    
    @Override
    public boolean addProduct(Product product) {

        boolean status = false;

        try {

            String query = "INSERT INTO products(product_name,description,price,stock,image_url,rating,brand_id,category_id) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setString(5, product.getImageUrl());
            ps.setDouble(6, product.getRating());
            ps.setInt(7, product.getBrandId());
            ps.setInt(8, product.getCategoryId());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    
    @Override
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setImageUrl(rs.getString("image_url"));
                product.setRating(rs.getDouble("rating"));
                product.setBrandId(rs.getInt("brand_id"));
                product.setCategoryId(rs.getInt("category_id"));

                list.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    
    @Override
    public List<Product> getProductsByCategory(int categoryId) {

        List<Product> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM products WHERE category_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setImageUrl(rs.getString("image_url"));
                product.setRating(rs.getDouble("rating"));
                product.setBrandId(rs.getInt("brand_id"));
                product.setCategoryId(rs.getInt("category_id"));

                list.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    @Override
    public List<Product> getProductsByBrand(int brandId) {

        List<Product> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM products WHERE brand_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, brandId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setImageUrl(rs.getString("image_url"));
                product.setRating(rs.getDouble("rating"));
                product.setBrandId(rs.getInt("brand_id"));
                product.setCategoryId(rs.getInt("category_id"));

                list.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    @Override
    public List<Product> searchProducts(String keyword) {

        List<Product> list =
                new ArrayList<>();

        try {

            String query =
                    "SELECT * FROM products WHERE product_name LIKE ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            
            while(rs.next()) {

                Product p =
                        new Product();

                p.setProductId(
                        rs.getInt("product_id"));

                p.setProductName(
                        rs.getString("product_name"));

                p.setDescription(
                        rs.getString("description"));

                p.setPrice(
                        rs.getDouble("price"));

                p.setStock(
                        rs.getInt("stock"));

                p.setImageUrl(
                        rs.getString("image_url"));

                p.setRating(
                        rs.getDouble("rating"));

                p.setBrandId(
                        rs.getInt("brand_id"));

                p.setCategoryId(
                        rs.getInt("category_id"));

                
                list.add(p);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    

}