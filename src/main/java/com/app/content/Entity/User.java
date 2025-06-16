package com.app.content.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    private String username;
    private String  email;
    private String password;
    private String role;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    @OneToMany(mappedBy = "user")
    private List<Comment> comments;


    
}
