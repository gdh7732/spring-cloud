package com.ocean.service.impl;

import java.util.List;

import com.ocean.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocean.domain.UpdateLog;
import com.ocean.repository.UpdateLogRepository;

@Service
public class UpdateLogServiceImpl implements UpdateLogService {
	
	@Autowired
	private UpdateLogRepository updateLogRepository;
	
	@Override
	public List<UpdateLog> list(String updateObjId) {
		return updateLogRepository.list(updateObjId);
	}

	@Override
	public void save(UpdateLog log) {
		updateLogRepository.save(log);
	}

}
