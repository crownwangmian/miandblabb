package com.iths.service.impl;

import com.iths.DAO.UserDAO;
import com.iths.domain.pojo.User;
import com.iths.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User addUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user = userDAO.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }


}
