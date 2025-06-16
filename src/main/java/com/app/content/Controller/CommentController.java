package com.app.content.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.content.Entity.Comment;
import com.app.content.Service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
    }  
    
    @GetMapping("/{commentID}")
    public ResponseEntity<Comment> get(@PathVariable Long commentID) {
        return ResponseEntity.ok(commentService.getComment(commentID));
    } 


    @GetMapping
    public List<Comment> getAll() {
        return commentService.getAllComment();
    } 

    @PutMapping("/put/{commentID}")
    public ResponseEntity<Comment> update(@PathVariable Long commentID, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(commentID,comment));
    } 

    @DeleteMapping("/delete/{commentID}")
    public ResponseEntity<Void> delete(@PathVariable Long commentID){
        commentService.deleteComment(commentID);
        return ResponseEntity.noContent().build();
    }  
}
