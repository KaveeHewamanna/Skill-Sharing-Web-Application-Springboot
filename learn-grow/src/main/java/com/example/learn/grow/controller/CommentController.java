package com.example.learn.grow.controller;

import com.example.learn.grow.model.Comment;
import com.example.learn.grow.service.CommentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
@RequiredArgsConstructor
@CrossOrigin("*") // Allows cross-origin requests from any domain

public class CommentController {

    private final CommentService commentService;

    /**
     * GET /api/comments
     * Retrieves a list of all comments.
     */

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    /**
     * GET /api/comments/{id}
     * Retrieves a single comment by its ID.
     * @param id ID of the comment
     */

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    /**
     * POST /api/comment
     * Creates a new comment.
     * @param comment Comment object to be created
     */

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    /**
     * PUT /api/comments/{id}
     * Updates an existing comment by its ID.
     * @param id ID of the comment to update
     * @param comment Updated comment data
     */

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(id, comment));
    }

    /**
     * DELETE /api/comments/{id}
     * Deletes a comment by its ID.
     * @param id ID of the comment to delete
     */

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
    
}
