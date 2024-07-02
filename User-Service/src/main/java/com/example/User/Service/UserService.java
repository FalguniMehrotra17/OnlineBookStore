package com.example.User.Service;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
    User updateUserProfile(String username, User updatedUser);
    void deleteUser(String username);
    
    
    // Example: Method to check if a user exists by username
    boolean existsByUsername(String username);
}

