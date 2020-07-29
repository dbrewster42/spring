package com.teks.users.user.controller;

import com.teks.users.user.model.User;
import com.teks.users.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public BookController(UserService userService){
        this.userService = userService;
    }

//    @GetMapping
//    public List<User> getAllUsers(){
//
//    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        User returnValue = userService.getUser(id);
        return returnValue;
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
}
