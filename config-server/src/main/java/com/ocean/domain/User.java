package com.ocean.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户表
 *
 * @author yinjihuan
 */
@Getter
@Setter
public class User {

    private Integer id;

    private String username;

    private String password;

    private Date gmtCreate;

    private Date gmtModify;

    private List<String> envs;

}
