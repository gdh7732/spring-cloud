package com.ocean.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ocean.domain.Config;
import com.ocean.mapper.ConfigMapper;
import com.ocean.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Boolean saveConfig(Config config) {
        int result = configMapper.saveConfig(config);
        return result > 0;
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
//        List<String> clients = CommonUtil.getZkClient().getClientServers(env, systemName);
        List<String> clients = Lists.newArrayList();
        for (String client : clients) {
            if (client.split("&")[1].equals(fileName)) {
                nodes.add(client.split("&")[0]);
            }
        }
        return nodes;
    }

}
