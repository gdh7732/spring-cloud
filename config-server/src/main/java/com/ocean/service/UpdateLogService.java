package com.ocean.service;

import java.util.List;

import com.ocean.domain.UpdateLog;

/**
 * 操作记录Service
 *
 * @author guodahai
 */
public interface UpdateLogService {

    /**
     * 查询更新记录
     *
     * @param updateObjId
     * @return
     */
    List<UpdateLog> queryUpdateLogList(String updateObjId);

    /**
     * 保存更新记录
     *
     * @param updateLog
     */
    void saveUpdateLog(UpdateLog updateLog);

}
