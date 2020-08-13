package com.teks.users.user.repository;

import com.teks.users.user.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User save(User user);
    User findByUserId(String userId);
    User findByEmail(String email);
    List<User> findAll();
    void delete(User user);
}
