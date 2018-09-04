package com.ocean.service.impl;

import com.ocean.domain.Config;
import com.google.common.collect.Lists;
import com.ocean.service.ConfService;
import com.ocean.util.CommonUtil;
import com.ocean.repository.ConfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfServiceImpl implements ConfService {
	
	@Autowired
	private ConfRepository confRepository;
	
	public List<Config> listForPage(String env, String systemName, String fileName, String key, int page, int limit) {
		return confRepository.listForPage(env, systemName, fileName, key, page, limit);
	}

	public List<Config> list(String env, String systemName, String fileName) {
		return confRepository.list(env, systemName, fileName);
	}

	public List<Config> list(String env, String systemName) {
		return confRepository.list(env, systemName);
	}

	public List<Config> list(String env) {
		return confRepository.list(env);
	}

	@Override
	public void save(Config config) {
		confRepository.save(config);
	}

	@Override
	public Config get(String id) {
		return confRepository.get(id);
	}

	@Override
	public List<Config> get(String env, String systemName, String fileName, String key) {
		List<Config> list = confRepository.listForPage(env, systemName, fileName, key, 1, 1);
		return list;
	}

	@Override
	public void remove(String id) {
		confRepository.remove(id);
	}

	@Override
	public List<String> getNodes(String env, String systemName, String fileName) {
		List<String> nodes = Lists.newArrayList();
		List<String> clients = CommonUtil.getZkClient().getClientServers(env, systemName);
		for (String client : clients) {
			if (client.split("&")[1].equals(fileName)) {
				nodes.add(client.split("&")[0]);
			}
		}
		return nodes;
	}

}
