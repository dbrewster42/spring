package com.teks.users.user.controller;

import com.teks.users.user.model.User;
import com.teks.users.user.model.request.UserRequest;
import com.teks.users.user.model.response.UserResponse;
import com.teks.users.user.service.UserService;
import com.teks.users.user.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_RSS_XML_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_RSS_XML_VALUE }
    )
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createdUser = userService.createUser(userDto);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable int id, @RequestBody UserRequest userRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto updatedUser = userService.updateUser(id, userDto);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
//        userService.updateUser(id, user);
    }
    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(value="page", defaultValue = "1") int page,
                                   @RequestParam(value="limit", defaultValue="5") int limit){
        List<UserDto> returnValue = userService.getAllUsers(page, limit);
        return returnValue;
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        User returnValue = userService.getUser(userId);
        return returnValue;
    }
    @GetMapping("/email/{email}")
    public User getUser(@PathVariable String email){
        User returnValue = userService.getUser(email);
        return returnValue;
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
//    @PostMapping
//    public void createUser(@RequestBody User user){
//        userService.createUser(user);
//    }

