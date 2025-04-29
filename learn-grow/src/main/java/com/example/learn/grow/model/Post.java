package com.example.learn.grow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")

//Create model class

public class Post {
    
    //Create variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String description;

    private String filePath;

    // Default constructor (required by JPA)
    public Post() {
    }

    // Constructor with fields (optional)
    public Post(String title, String description,String filePath) {
        this.title = title;
        this.description = description;
        this.filePath = filePath;
    }

    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String decription, String description) {
                this.description = description;
    }

}
