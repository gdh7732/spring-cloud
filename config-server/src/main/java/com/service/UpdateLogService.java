package com.service;

import java.util.List;

import com.domain.UpdateLog;

public interface UpdateLogService {

    List<UpdateLog> list(String updateObjId);

    void save(UpdateLog log);

}
