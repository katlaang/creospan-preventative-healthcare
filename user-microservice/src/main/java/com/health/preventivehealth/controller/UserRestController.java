package com.health.preventivehealth.controller;

import com.health.preventivehealth.exception.UserNotFoundException;
import com.health.preventivehealth.model.User;
import com.health.preventivehealth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = repository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("User not found with ID: "+id);
        return ResponseEntity.ok().body(user.get());
    }

    @PutMapping(value = "/users")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
        Long id = user.getId();
        if(id == null || ! repository.findById(id).isPresent())
            throw new UserNotFoundException("User not found with ID: "+id);
        User updatedUser = repository.save(user);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("User not found with ID: "+id);
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

}
