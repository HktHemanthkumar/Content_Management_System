package com.app.content.Repository;

import com.app.content.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // Add this line:
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username); 
}

