package com.app.content.Controller;

import com.app.content.Entity.User;
import com.app.content.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<User> get(@PathVariable Long userID) {
        return ResponseEntity.ok(userService.getUser(userID));
    }

    // ✅ Pagination with metadata
    
    @PutMapping("/put/{userID}")
    public ResponseEntity<User> update(@PathVariable Long userID, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(userID, user));
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<Void> delete(@PathVariable Long userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }
}
