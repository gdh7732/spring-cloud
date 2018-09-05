package com.ocean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocean.domain.User;
import com.ocean.mapper.UserMapper;
import com.ocean.service.UserService;

/**
 * 用户Service
 *
 * @author gupdahai
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String username, String password) {
        return userMapper.queryUser(username, password);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public boolean exists(String username) {
        int result = userMapper.exists(username);
        return result > 0;
    }

}
