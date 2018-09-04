package com.ocean.rest;

import java.util.Date;

import com.ocean.domain.Config;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ocean.common.GlobalException;
import com.ocean.common.ParamException;
import com.ocean.common.ResponseData;
import com.ocean.common.ServerException;
import com.ocean.service.ConfService;

/**
 * 配置信息rest接口
 * @author yinjihuan
 * @date 2017-02-22
 */
@RestController
public class ConfRestApi {
	
	@Autowired
	private ConfService confService;
	
	@GetMapping("/rest/conf/list/{env}")
	public ResponseData list(@PathVariable("env") String env) throws GlobalException {
		try {
			if (StringUtils.isBlank(env)) {
				throw new ParamException("env not null");
			}
			return ResponseData.ok(confService.list(env));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@GetMapping("/rest/conf/list/{env}/{systemName}")
	public ResponseData list(@PathVariable("env") String env, @PathVariable("systemName") String systemName) throws GlobalException {
		try {
			if (StringUtils.isBlank(env)) {
				throw new ParamException("env not null");
			}
			if (StringUtils.isBlank(systemName)) {
				throw new ParamException("systemName not null");
			}
			return ResponseData.ok(confService.list(env, systemName));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@GetMapping("/rest/conf/list/{env}/{systemName}/{confFileName}")
	public ResponseData list(@PathVariable("env") String env, 
			@PathVariable("systemName") String systemName,
			@PathVariable("confFileName") String confFileName) throws GlobalException {
		try {
			if (StringUtils.isBlank(env)) {
				throw new ParamException("env not null");
			}
			if (StringUtils.isBlank(systemName)) {
				throw new ParamException("systemName not null");
			}
			if (StringUtils.isBlank(confFileName)) {
				throw new ParamException("confFileName not null");
			}
			return ResponseData.ok(confService.list(env, systemName, confFileName));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@GetMapping("/rest/conf/list/{env}/{systemName}/{confFileName}/{key}")
	public ResponseData list(@PathVariable("env") String env, 
			@PathVariable("systemName") String systemName,
			@PathVariable("confFileName") String confFileName,
			@PathVariable("key") String key) throws GlobalException {
		try {
			if (StringUtils.isBlank(env)) {
				throw new ParamException("env not null");
			}
			if (StringUtils.isBlank(systemName)) {
				throw new ParamException("systemName not null");
			}
			if (StringUtils.isBlank(confFileName)) {
				throw new ParamException("confFileName not null");
			}
			if (StringUtils.isBlank(key)) {
				throw new ParamException("key not null");
			}
			return ResponseData.ok(confService.get(env, systemName, confFileName, key));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@GetMapping("/rest/conf/{id}")
	public ResponseData get(@PathVariable("id") String id) throws GlobalException {
		try {
			if (StringUtils.isBlank(id)) {
				throw new ParamException("id not null");
			}
			return ResponseData.ok(confService.get(id));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@PostMapping("/rest/conf")
	public ResponseData save(@RequestBody Config config) throws GlobalException {
		if (StringUtils.isBlank(config.getEnv())) {
			throw new ParamException("env not null");
		}
		if (StringUtils.isBlank(config.getSystemName())) {
			throw new ParamException("systemName not null");
		}
		if (StringUtils.isBlank(config.getConfFileName())) {
			throw new ParamException("confFileName not null");
		}
		if (StringUtils.isBlank(config.getKey())) {
			throw new ParamException("key not null");
		}
		if (config.getValue() == null) {
			throw new ParamException("value not null");
		}
		if (StringUtils.isBlank(config.getDesc())) {
			throw new ParamException("desc not null");
		}
		config.setCreateDate(new Date());
		config.setModifyDate(new Date());
		confService.save(config);
		return ResponseData.ok();
	}
	
	@PostMapping("/rest/conf/update")
	public ResponseData redesc(@RequestBody Config config) throws GlobalException {
		if (StringUtils.isBlank(config.getId())) {
			throw new ParamException("id not null");
		}
		if (StringUtils.isBlank(config.getEnv())) {
			throw new ParamException("env not null");
		}
		if (StringUtils.isBlank(config.getSystemName())) {
			throw new ParamException("systemName not null");
		}
		if (StringUtils.isBlank(config.getConfFileName())) {
			throw new ParamException("confFileName not null");
		}
		if (StringUtils.isBlank(config.getKey())) {
			throw new ParamException("key not null");
		}
		if (config.getValue() == null) {
			throw new ParamException("value not null");
		}
		if (StringUtils.isBlank(config.getDesc())) {
			throw new ParamException("desc not null");
		}
		config.setModifyDate(new Date());
		confService.save(config);
		return ResponseData.ok();
	}
}
