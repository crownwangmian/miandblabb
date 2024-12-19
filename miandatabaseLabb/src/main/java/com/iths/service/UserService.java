package com.iths.service;

import com.iths.domain.pojo.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    List<User> findAllUsers();
}
