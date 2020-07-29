package com.teks.users.user.service;

import com.teks.users.user.model.User;
import com.teks.users.user.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        returnValue = (List<User>) userRepository.findAll();
        return returnValue;
    }

    @Override
    public User getUser(int id){
        User returnValue = userRepository.findById(id);
        return returnValue;
    }
    @Override
    public User getUser(String email){
        User returnValue = userRepository.findByEmail(email);
        return returnValue;
    }
    @Override
    public void deleteUser(int id){
        User deleteValue = userRepository.findById(id);
//        userRepository.deleteUser(deleteValue);
        userRepository.delete(deleteValue);
    }
    @Override
    public User updateUser(int id, User user){
        User updateValue = userRepository.findById(id);
        updateValue = user;
        userRepository.save(updateValue);
        return updateValue;
    }

}
