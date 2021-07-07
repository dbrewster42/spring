package com.teks.users.user.controller;

import com.teks.users.user.model.User;
import com.teks.users.user.model.request.UserRequest;
import com.teks.users.user.model.response.UserResponse;
import com.teks.users.user.service.UserService;
import com.teks.users.user.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_RSS_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_RSS_XML_VALUE }
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
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserRequest userRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto updatedUser = userService.updateUser(userId, userDto);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @GetMapping
    public List<UserResponse> getAllUsers(@RequestParam(value="page", defaultValue = "1") int page,
                                   @RequestParam(value="limit", defaultValue="5") int limit){

        List<UserDto> userList = userService.getAllUsers(page, limit);
        List<UserResponse> returnValue = new ArrayList<UserResponse>();
        for (UserDto eachUser : userList){
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(eachUser, userResponse);
            returnValue.add(userResponse);
        }
        return returnValue;
    }
    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId){
        UserDto userDto = userService.getUser(userId);
        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }
    @GetMapping("/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        UserDto userDto = userService.getUser(email);
        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @DeleteMapping("/{userid}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User Deleted";
    }
}

