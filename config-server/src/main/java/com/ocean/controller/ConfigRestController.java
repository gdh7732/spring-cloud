package com.ocean.controller;

import java.util.Date;

import com.ocean.domain.Config;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ocean.common.GlobalException;
import com.ocean.common.ParamException;
import com.ocean.common.ResponseData;
import com.ocean.common.ServerException;
import com.ocean.service.ConfigService;

/**
 * 配置信息rest接口
 * @author yinjihuan
 * @date 2017-02-22
 */
@RestController
public class ConfigRestController {
	
	@Autowired
	private ConfigService configService;
	
	@GetMapping("/rest/conf/list/{env}")
	public ResponseData list(@PathVariable("env") String env) throws GlobalException {
		try {
			if (StringUtils.isBlank(env)) {
				throw new ParamException("env not null");
			}
			Config config = new Config();
			config.setEnv(env);
			return ResponseData.ok(configService.queryConfigList(config));
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
			Config config = new Config();
			config.setEnv(env);
			config.setSystemName(systemName);
			return ResponseData.ok(configService.queryConfigList(config));
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
			Config config = new Config();
			config.setEnv(env);
			config.setSystemName(systemName);
			config.setConfFileName(confFileName);
			return ResponseData.ok(configService.queryConfigList(config));
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
			Config config = new Config();
			config.setKey(key);
			config.setConfFileName(confFileName);
			config.setSystemName(systemName);
			config.setEnv(env);
			return ResponseData.ok(configService.queryConfigList(config).get(0));
		} catch (Exception e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@GetMapping("/rest/conf/{id}")
	public ResponseData get(@PathVariable("id") Integer id) throws GlobalException {
		try {
			if (null == id) {
				throw new ParamException("id not null");
			}
			return ResponseData.ok(configService.queryConfig(id));
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
		config.setGmtCreate(new Date());
		config.setGmtModify(new Date());
		configService.saveConfig(config);
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
		config.setGmtModify(new Date());
		configService.saveConfig(config);
		return ResponseData.ok();
	}
}
