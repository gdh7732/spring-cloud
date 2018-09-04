package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.UpdateLog;
import com.repository.UpdateLogRepository;

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
