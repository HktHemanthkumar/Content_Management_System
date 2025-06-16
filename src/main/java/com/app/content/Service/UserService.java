package com.app.content.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.content.Entity.User;
import com.app.content.Repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    // Create a new user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Get a user by ID
    public User getUser(Long userID) {
        return userRepo.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get all users (non-paginated)
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    

    // Update user details
    public User updateUser(Long userID, User updatedUser) {
        User existing = getUser(userID);
        existing.setUsername(updatedUser.getUsername());
        existing.setEmail(updatedUser.getEmail());
        existing.setPassword(updatedUser.getPassword());
        existing.setRole(updatedUser.getRole());
        return userRepo.save(existing);
    }

    // Delete a user by ID
    public void deleteUser(Long userID) {
        userRepo.deleteById(userID);
    }
}
