package com.example.springjwt.api;

import com.example.springjwt.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User createUser(User user);

    void deleteUser(Long id);
}
