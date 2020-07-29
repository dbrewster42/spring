package com.teks.users.user.service;

import com.teks.users.user.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    User getUser(String email);
    void createUser(User user);
    void deleteUser(int id);
    User updateUser(int id, User user);
}
