package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Product;

public interface ProductDAO {

    // Add Product
    boolean addProduct(Product product);

    
    // Get All Products
    List<Product> getAllProducts();

    
    // Get Products By Category
    List<Product> getProductsByCategory(int categoryId);

    
    // Get Products By Brand
    List<Product> getProductsByBrand(int brandId);
    
    
    List<Product> searchProducts(String keyword);

}