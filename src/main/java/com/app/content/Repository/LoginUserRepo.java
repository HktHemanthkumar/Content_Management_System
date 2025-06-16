package com.app.content.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.content.Entity.LoginUser;

import java.util.Optional;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, String> {
     Optional<LoginUser> findByUsername(String username);
     boolean existsByUsername(String username);
}

