package com.ocean.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ocean.domain.User;

/**
 * 用户Mapper
 *
 * @author guodahai
 * @version 2018/9/5 13:53
 */
@Mapper
public interface UserMapper {

    /**
     * 获取用户信息
     *
     * @param userName
     * @param password
     * @return
     */
    User queryUser(@Param("userName") String userName, @Param("password") String password);

    /**
     * 创建用户
     *
     * @param user
     * @return int
     */
    int saveUser(User user);

    /**
     * 校验用户名
     *
     * @param userName
     * @return int
     */
    int exists(String userName);

}
