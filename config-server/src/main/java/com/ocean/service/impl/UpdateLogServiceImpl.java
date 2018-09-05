package com.ocean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocean.domain.UpdateLog;
import com.ocean.mapper.UpdateLogMapper;
import com.ocean.service.UpdateLogService;

/**
 * 操作记录Service
 *
 * @author guodahai
 */
@Service
public class UpdateLogServiceImpl implements UpdateLogService {

    @Autowired
    private UpdateLogMapper updateLogMapper;

    @Override
    public List<UpdateLog> queryUpdateLogList(String updateObjId) {
        return updateLogMapper.queryUpdateLogList(updateObjId);
    }

    @Override
    public void saveUpdateLog(UpdateLog updateLog) {
        updateLogMapper.saveUpdateLog(updateLog);
    }

}
