package com.teks.users.user.service;

import com.teks.users.user.dto.UserDto;
import com.teks.users.user.model.User;
import com.teks.users.user.repository.UserRepository;
import com.teks.users.user.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final Utils utils;

    public UserServiceImplementation(UserRepository userRepository,  Utils utils){
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @Override
//    public void createUser(User user){
    public UserDto createUser(UserDto userDto){
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);

//        newUser.setEncryptedPassword("test");
        newUser.setEmailVerificationStatus(utils.emailIsValid(userDto));
        if (!newUser.getEmailVerificationStatus()){

        }
        newUser.setUserId(utils.generateUserId(15));

        User storedUserDetails = userRepository.save(newUser);
        if (storedUserDetails == null){
//            throw UserException.
        }

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
//        userRepository.save(user);
    }
    @Override
    public UserDto updateUser(int id, UserDto userDto){
        User updatedUser = userRepository.findById(id);
//        User updateValue = userRepository.findById(id);
//        updateValue = userDto;
        BeanUtils.copyProperties(updatedUser, userDto);
        userRepository.save(updatedUser);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers(int page, int limit){
        List<User> userList = new ArrayList<>();
//        returnValue = (List<User>) userRepository.findAll();
        if (page > 0) page--;
        Pageable pageRequest = PageRequest.of(page, limit);
        Page<User> userPage = userRepository.findAll(pageRequest);
        userList = userPage.getContent();
        List<UserDto> returnValue = new ArrayList<>();
        for (User eachUser : userList){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(eachUser, userDto);
            returnValue.add(userDto);
        }
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


}
