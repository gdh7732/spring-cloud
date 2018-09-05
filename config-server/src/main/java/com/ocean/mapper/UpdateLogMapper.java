package com.ocean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ocean.domain.UpdateLog;

/**
 * @author guodahai
 * @version 2018/9/5 13:53
 */
@Mapper
public interface UpdateLogMapper {

    /**
     * 保存更新记录
     *
     * @param log
     */
    void saveUpdateLog(UpdateLog log);

    /**
     * 查询更新记录
     *
     * @param updateObjId
     * @return
     */
    List<UpdateLog> queryUpdateLogList(String updateObjId);
}
