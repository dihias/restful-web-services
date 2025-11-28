package com.didi.rest.webservices.restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> FindAllUsers()
    {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User FindUser(@PathVariable int id)
    {
        return userDaoService.findUser(id);
    }

    @PostMapping("/users")
    public void AddUser(@RequestBody User user)
    {
        userDaoService.saveUser(user);
    }
}
