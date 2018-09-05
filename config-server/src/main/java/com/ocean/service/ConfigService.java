package com.ocean.service;

import com.ocean.domain.Config;

import java.util.List;

/**
 * 配置信息Service
 *
 * @author guodahai
 */
public interface ConfigService {

    /**
     * 保存配置信息
     *
     * @param config
     */
    Boolean saveConfig(Config config);

    /**
     * 查询配置信息
     *
     * @param id
     * @return
     */
    Config queryConfig(Integer id);

    /**
     * 移除配置信息
     *
     * @param id
     */
    void removeConfig(Integer id);

    /**
     * 动态查询配置信息
     *
     * @param config
     * @return
     */
    List<Config> queryConfigList(Config config);

    /**
     * 分页查询配置信息
     *
     * @param config
     * @param page
     * @param limit
     * @return
     */
    List<Config> queryConfigByPage(Config config, int page, int limit);

    /**
     * 配置列表页面
     *
     * @param env
     * @param systemName
     * @param fileName
     * @return
     */
    List<String> getNodes(String env, String systemName, String fileName);

}
