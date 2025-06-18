package com.app.content.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.app.content.Entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
    
    
}
