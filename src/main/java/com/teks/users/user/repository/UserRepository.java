package com.teks.users.user.repository;

import com.teks.users.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User save(User user);
    User findById(int id);
    User findByEmail(String email);
    List<User> findAll();
    void delete(User user);
}
