package com.example.learn.grow.service;

import com.example.learn.grow.model.Post;
import com.example.learn.grow.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private static final String UPLOAD_DIR = "uploads/";

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(String title, String description, MultipartFile file) {
        String fileName = null;

        if (file != null && !file.isEmpty()) {
            try {
                fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                Files.createDirectories(filePath.getParent());
                file.transferTo(filePath.toFile());
            } catch (IOException e) {
                throw new RuntimeException("File upload failed", e);
            }
        }

        Post post = new Post(title, description, fileName);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = getPostById(id);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setDescription(postDetails.getDescription());
            return postRepository.save(post);
        }
        return null;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
