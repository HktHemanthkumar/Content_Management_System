package com.app.content.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.app.content.Entity.Tag;

@Repository
public interface TagRepo extends JpaRepository<Tag,Long> {
    
    
}
