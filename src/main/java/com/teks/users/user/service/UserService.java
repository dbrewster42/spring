package com.teks.users.user.service;

import com.teks.users.user.model.User;
import com.teks.users.user.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers(int page, int limit);
    User getUser(String userId);
    User getUser(String email);
    UserDto createUser(UserDto userDto);
    void deleteUser(String userId);
    UserDto updateUser(String userId, UserDto userDto);
}
