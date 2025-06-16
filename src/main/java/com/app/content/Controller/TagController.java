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

import com.app.content.Entity.Tag;
import com.app.content.Service.TagService;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        return new ResponseEntity<>(tagService.createTag(tag), HttpStatus.CREATED);
    } 


    @GetMapping("/{tagID}")
    public ResponseEntity<Tag> get(@PathVariable Long tagID) {
        return ResponseEntity.ok(tagService.getTag(tagID));
    } 


    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAllTag();
    } 

    @PutMapping("/put/{tagID}")
    public ResponseEntity<Tag> update(@PathVariable Long tagID, @RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.updateTag(tagID,tag));
    } 

    @DeleteMapping("/delete/{tagID}")
    public ResponseEntity<Void> delete(@PathVariable Long tagID){
        tagService.deleteTag(tagID);
        return ResponseEntity.noContent().build();
    } 
    
}
