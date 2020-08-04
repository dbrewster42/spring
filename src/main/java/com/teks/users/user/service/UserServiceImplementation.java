package com.teks.users.user.service;

import com.teks.users.user.dto.UserDto;
import com.teks.users.user.exceptions.InvalidEmailException;
import com.teks.users.user.exceptions.UserExceptions;
import com.teks.users.user.exceptions.UserNotFoundException;
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
//    public UserServiceImplementation(){
//
//    }

    @Override
    public UserDto createUser(UserDto userDto){
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);

        newUser.setEncryptedPassword("test");
        newUser.setEmailVerificationStatus(utils.emailIsValid(userDto));
        if (!newUser.getEmailVerificationStatus()){
            throw new InvalidEmailException("Email Is Not Valid!");
        }
        newUser.setUserId(utils.generateUserId(15));

        User storedUserDetails = userRepository.save(newUser);
        if (storedUserDetails == null){ throw new UserNotFoundException(); }

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto){
        User updatedUser = userRepository.findByUserId(userId);
        if (updatedUser == null){
            throw new UserNotFoundException("The user does not exist");
        }
        userDto.setEmail(updatedUser.getEmail());
        BeanUtils.copyProperties(userDto, updatedUser);
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
    public UserDto getUser(String userId){
        User user = userRepository.findByUserId(userId);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(user, returnValue);
        return returnValue;
    }
    @Override
    public UserDto getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(user, returnValue);
        return returnValue;
    }
    @Override
    public void deleteUser(String userId){
        User deleteValue = userRepository.findByUserId(userId);
//        userRepository.deleteUser(deleteValue);
        userRepository.delete(deleteValue);
    }


}
