package com.app.content.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.app.content.Entity.Post;
import com.app.content.Repository.PostRepo;
import org.springframework.data.domain.PageRequest;
@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    // Create a new post
    public Post createPost(Post post){
        return postRepo.save(post);
    }

    // Get a post by ID
    public Post getPost(Long postID){
        return postRepo.findById(postID)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // Get all posts (non-paginated)
    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    // Get all posts (paginated)
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepo.findAll(pageable);
    }

    // Update an existing post
    public Post updatePost(Long postID, Post updatePost){
        Post existing = getPost(postID);
        existing.setTitle(updatePost.getTitle());
        existing.setContent(updatePost.getContent());
        return postRepo.save(existing);
    }

    // Delete a post by ID
    public void deletePost(Long postID){
        postRepo.deleteById(postID);
    }


    public Page<Post> getPaginatedPosts(int page, int size) {
    return postRepo.findAll(PageRequest.of(page, size));
    }

    public Page<Post> getPaginatedPosts(int page, int size, String sortBy) {
    return postRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}
