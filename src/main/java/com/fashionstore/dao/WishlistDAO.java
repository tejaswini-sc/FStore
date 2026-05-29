package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Wishlist;

public interface WishlistDAO {

    // Add to Wishlist
    boolean addToWishlist(Wishlist wishlist);

    
    // Remove from Wishlist
    boolean removeFromWishlist(int wishlistId);

    
    // Get Wishlist By User
    List<Wishlist> getWishlistByUser(int userId);

}