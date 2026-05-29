package com.fashionstore.dao;

import com.fashionstore.model.User;

public interface UserDAO {

    // Register User
    boolean registerUser(User user);

    
    // Login User
    User loginUser(String email, String password);

}