package com.teks.users.user.service;

import com.teks.users.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.UserRepository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user){
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        List<User> returnValue = new ArrayList<>();
        returnValue = (List<Book>) userRepository.findAll();
        return returnValue;
    }

}
