package com.ocean.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 配置信息集合
 *
 * @author yinjihuan
 * @date 2017-02-21
 */
@Getter
@Setter
public class Config {

    private String id;
    /**
     * 环境
     */
    private String env;
    /**
     * 系统名称
     */
    private String systemName;
    /**
     * 配置文件名称
     */
    private String confFileName;
    /**
     * 配置Key
     */
    private String key;
    /**
     * 配置Value
     */
    private String value;
    /**
     * 描述
     */
    private String desc;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;

}
