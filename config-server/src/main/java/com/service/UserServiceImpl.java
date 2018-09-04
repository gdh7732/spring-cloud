package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String username, String pass) {
        return userRepository.getUser(username, pass);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean exists(String username) {
        return userRepository.exists(username);
    }

}
