package com.app.content.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.content.Entity.Comment;
import com.app.content.Repository.CommentRepo;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public Comment createComment(Comment comment){
        return commentRepo.save(comment);
    }
    public Comment getComment(Long commentID){
        return commentRepo.findById(commentID).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public List<Comment> getAllComment(){
        return commentRepo.findAll();
    }

    public Comment updateComment(Long commentID, Comment updateComment){
        Comment existing= getComment((commentID));
        return commentRepo.save(existing);
    }
    public void deleteComment(Long commentID){
        commentRepo.deleteById(commentID);
    }
    
}
