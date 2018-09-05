package com.ocean.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 修改日志记录
 *
 * @author yinjihuan
 */
@Getter
@Setter
public class UpdateLog {

    private Integer id;
    /**
     * 用户
     */
    private String username;
    /**
     * 修改对象（Config）的ID
     */
    private Integer updateObjId;
    /**
     * 原始值
     */
    private String oldValue;
    /**
     * 修改之后的值
     */
    private String newValue;
    /**
     * 修改描述
     */
    private String updateDesc;

    private Date gmtCreate;

    private Date gmtModify;

}
