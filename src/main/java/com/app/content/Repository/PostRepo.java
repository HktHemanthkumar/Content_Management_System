package com.app.content.Repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.content.Entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.user.userID = :userId")
    List<Post> findPostsByUserId(@Param("userId") Long userId);

    @Query("SELECT DISTINCT p FROM Post p JOIN p.comments c")
    List<Post> findPostsWithComments();

    
}

