package com.ocean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ocean.domain.Config;
import com.ocean.mapper.ConfigMapper;
import com.ocean.service.ConfigService;
import com.ocean.util.CommonUtil;

/**
 * 配置信息Service
 *
 * @author guodahai
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public void saveConfig(Config config) {
        configMapper.saveConfig(config);
    }

    @Override
    public Config queryConfig(Integer id) {
        return configMapper.queryConfig(id);
    }

    @Override
    public void removeConfig(Integer id) {
        configMapper.removeConfig(id);
    }

    @Override
    public List<Config> queryConfigList(Config config) {
        return configMapper.queryConfigList(config);
    }

    @Override
    public List<Config> queryConfigByPage(Config config, int page, int limit) {
        PageHelper.startPage(page, limit);
        return configMapper.queryConfigByPage(config);
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
