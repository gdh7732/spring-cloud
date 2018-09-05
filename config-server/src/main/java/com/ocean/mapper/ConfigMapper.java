package com.ocean.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.ocean.domain.Config;

/**
 * 配置信息Mapper
 *
 * @author guodahai
 * @version 2018/9/5 13:53
 */
public interface ConfigMapper {

    /**
     * 保存配置信息
     *
     * @param config
     */
    void saveConfig(Config config);

    /**
     * 查询配置信息
     *
     * @param id
     * @return
     */
    Config queryConfig(String id);

    /**
     * 移除配置信息
     *
     * @param id
     */
    void removeConfig(String id);

    /**
     * 分页查询配置信息
     *
     * @param config
     * @return
     */
    Page<Config> queryConfigByPage(Config config);

    /**
     * 动态查询配置信息
     *
     * @param config
     * @return
     */
    List<Config> queryConfigList(Config config);

}
