package com.app.content.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.content.Entity.Tag;
import com.app.content.Repository.TagRepo;

@Service
public class TagService {

    @Autowired
    private TagRepo tagRepo;
    public Tag createTag(Tag tag){
        return tagRepo.save(tag);
    }
    public Tag getTag(Long tagID){
        return tagRepo.findById(tagID).orElseThrow(() -> new RuntimeException("Tag not found"));
    }
    public List<Tag> getAllTag(){
        return tagRepo.findAll();
    }
    public Tag updateTag(Long tagID, Tag updatedTag){
        Tag existing = getTag(tagID);
        existing.setTag_name(updatedTag.getTag_name());
        existing.setDescription(updatedTag.getDescription());
        existing.setCreated_at(updatedTag.getCreated_at());
        return tagRepo.save(existing);
    }
    public void deleteTag(Long tagID){
        tagRepo.deleteById(tagID);
    }
}
