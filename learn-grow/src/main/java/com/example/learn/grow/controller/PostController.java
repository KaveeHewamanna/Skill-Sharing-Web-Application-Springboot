package com.example.learn.grow.controller;

//Create controller class
import com.example.learn.grow.model.Post;

import lombok.RequiredArgsConstructor;
import com.example.learn.grow.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")

public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    //Add post method to create post
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
    //Create put method to update post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        return postService.updatePost(id, postDetails);
    }

    //Create delete method to delete post by using id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
       postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    
}
