package com.ocean.service;

import com.ocean.domain.User;

/**
 * 用户Service
 *
 * @author gupdahai
 */
public interface UserService {

    /**
     * 获取用户信息
     *
     * @param username
     * @param password
     * @return
     */
    User queryUser(String username, String password);

    /**
     * 创建用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 校验用户名
     *
     * @param username
     * @return
     */
    boolean exists(String username);

}
