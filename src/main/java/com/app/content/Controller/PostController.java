package com.app.content.Controller;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.content.Entity.Post;
import com.app.content.Service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    // Get a single post by ID
    @GetMapping("/{postID}")
    public ResponseEntity<Post> get(@PathVariable Long postID) {
        return ResponseEntity.ok(postService.getPost(postID));
    }

    // Get all posts with pagination
    @GetMapping
    public ResponseEntity<Page<Post>> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Post> paginatedPosts = postService.getAllPosts(PageRequest.of(page, size));
        return ResponseEntity.ok(paginatedPosts);
    }

    // Update a post by ID
    @PutMapping("/put/{postID}")
    public ResponseEntity<Post> update(@PathVariable Long postID, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(postID, post));
    }

    // Delete a post by ID
    @DeleteMapping("/delete/{postID}")
    public ResponseEntity<Void> delete(@PathVariable Long postID) {
        postService.deletePost(postID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posts/paginated")
    public Page<Post> getPaginatedPosts(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
    return postService.getPaginatedPosts(page, size);
    }

    @GetMapping("/paginated")
    public Page<Post> getPaginatedPosts(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size,
                                    @RequestParam(defaultValue = "postID") String sortBy) {
    return postService.getPaginatedPosts(page, size, sortBy);
    }


    

}
