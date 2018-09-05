package com.ocean.controller;

import com.ocean.common.*;
import com.ocean.domain.Config;
import com.ocean.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 配置信息rest接口
 *
 * @author yinjihuan
 * @date 2017-02-22
 */
@RestController
public class ConfigRestController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/rest/conf/list")
    public ResponseResult<List<Config>> list(@RequestBody Config config) {
        return new AbstractControllerExecutor<List<Config>>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.nullCheck(config);
            }

            @Override
            public List<Config> executeService() {
                return configService.queryConfigList(config);
            }
        }.execute(config);
    }

    @GetMapping("/rest/conf/{id}")
    public ResponseResult<Config> get(@PathVariable("id") Integer id) {
        return new AbstractControllerExecutor<Config>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.nullCheck(id);
            }

            @Override
            public Config executeService() throws ServiceException {
                return configService.queryConfig(id);
            }
        }.execute(id);
    }

    @PostMapping("/rest/conf")
    public ResponseResult<Boolean> save(@RequestBody Config config) {
        return new AbstractControllerExecutor<Boolean>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.nullCheck(config);
            }

            @Override
            public Boolean executeService() throws ServiceException {
                return configService.saveConfig(config);
            }
        }.execute(config);
    }

    @PutMapping("/rest/conf")
    public ResponseResult<Boolean> update(@RequestBody Config config) {
        return new AbstractControllerExecutor<Boolean>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.nullCheck(config);
            }

            @Override
            public Boolean executeService() throws ServiceException {
                return configService.saveConfig(config);
            }
        }.execute(config);
    }
}
