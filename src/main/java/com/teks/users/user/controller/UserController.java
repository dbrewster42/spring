package com.teks.users.user.controller;

import com.teks.users.user.model.User;
import com.teks.users.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        List<User> returnValue = userService.getAllUsers();
        return returnValue;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        User returnValue = userService.getUser(id);
        return returnValue;
    }
    @GetMapping("/email/{email}")
    public User getUser(@PathVariable String email){
        User returnValue = userService.getUser(email);
        return returnValue;
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user){
        userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
//        User removeValue = userService.getUser(id);
        userService.deleteUser(id);
    }
}
