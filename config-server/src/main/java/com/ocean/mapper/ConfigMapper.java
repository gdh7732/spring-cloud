package com.ocean.mapper;

import com.github.pagehelper.Page;
import com.ocean.domain.Config;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 配置信息Mapper
 *
 * @author guodahai
 * @version 2018/9/5 13:53
 */
@Mapper
public interface ConfigMapper {

    /**
     * 保存配置信息
     *
     * @param config
     * @return
     */
    int saveConfig(Config config);

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
     * @return
     */
    int removeConfig(Integer id);

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
