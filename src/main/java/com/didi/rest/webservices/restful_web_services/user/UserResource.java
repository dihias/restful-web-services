package com.didi.rest.webservices.restful_web_services.user;

import com.didi.rest.webservices.restful_web_services.user.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> FindAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> FindUser(@PathVariable int id)
    {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> FindUserPosts(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);
        return user.get().getPosts();
    }

    @PostMapping("/users")
    public ResponseEntity<User> AddUser(@Valid @RequestBody User user)
    {
        User savedUser=userRepository.save(user);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }
}
