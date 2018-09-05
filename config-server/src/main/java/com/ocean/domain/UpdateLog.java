package com.ocean.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    public UpdateLog() {
    }

    public UpdateLog(String username, Integer updateObjId, String oldValue, String newValue, String updateDesc) {
        this.username = username;
        this.updateObjId = updateObjId;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.updateDesc = updateDesc;
    }
}
