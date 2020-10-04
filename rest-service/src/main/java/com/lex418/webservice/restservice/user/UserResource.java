package com.lex418.webservice.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userDaoService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/users/{id}")
//    public User retrieveUser(@PathVariable int id){
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-" +id);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@Valid @PathVariable int id){
        User user = userDaoService.removeUser(id);
        if(user==null)
            throw new UserNotFoundException("id-" +id);
    }

}
