package com.app.content.Entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagID;
    private String tag_name;
    private String description ;
    private Time created_at;
    
    
    

   

    
}
