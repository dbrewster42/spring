package com.teks.users.user.service;

import com.teks.users.user.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(int id);
    void createUser(User user);
}
