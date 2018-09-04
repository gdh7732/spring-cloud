package com.ocean.service;

import java.util.List;

import com.ocean.domain.UpdateLog;

public interface UpdateLogService {

    List<UpdateLog> list(String updateObjId);

    void save(UpdateLog log);

}
