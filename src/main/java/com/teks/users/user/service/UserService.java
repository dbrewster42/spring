package com.teks.users.user.service;

import com.teks.users.user.model.User;
import com.teks.users.user.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers(int page, int limit);
    User getUser(int id);
    User getUser(String email);
    UserDto createUser(UserDto userDto);
    void deleteUser(int id);
    UserDto updateUser(int id, UserDto userDto);
}
