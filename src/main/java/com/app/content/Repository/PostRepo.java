package com.app.content.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.content.Entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);
}

