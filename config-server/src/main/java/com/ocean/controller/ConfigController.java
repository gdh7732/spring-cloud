package com.ocean.controller;

import com.google.common.collect.Lists;
import com.ocean.common.*;
import com.ocean.domain.Config;
import com.ocean.model.ConfigModel;
import com.ocean.model.NodeInfo;
import com.ocean.service.ConfigService;
import com.ocean.service.NodeService;
import com.ocean.service.UpdateLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 配置管理控制器
 *
 * @author yinjihuan
 */
@Controller
public class ConfigController {

    @Autowired
    private ConfigService configService;
    @Autowired
    private UpdateLogService updateLogService;
    @Autowired
    private NodeService nodeService;

    /**
     * 配置列表页面
     *
     * @param config
     * @param model
     * @return
     * @author yinjihuan
     */
    @GetMapping("/")
    public String index(ConfigModel config, Map<String, Object> model, HttpServletRequest request) {
        List<String> envs = LoginUserInfoUtils.getLoginUserEvns(request);
        if (StringUtils.isBlank(config.getEnv())) {
            if (envs.contains(EnvConstants.DEV)) {
                config.setEnv(EnvConstants.DEV);
            } else if (envs.contains(EnvConstants.TEST)) {
                config.setEnv(EnvConstants.TEST);
            } else if (envs.contains(EnvConstants.ONLINE)) {
                config.setEnv(EnvConstants.ONLINE);
            } else if (envs.contains(EnvConstants.PROD)) {
                config.setEnv(EnvConstants.PROD);
            }
        }

        if (envs.contains(config.getEnv())) {
            if (config.getPage() == 0) {
                config.setPage(1);
            }
            List<Config> list = configService.queryConfigByPage(config, config.getPage(), 20);
            List<ConfigModel> results = Lists.newArrayList();
            for (Config c : list) {
                ConfigModel cm = new ConfigModel();
                BeanUtils.copyProperties(c, cm);
                cm.setNodes(configService.getNodes(c.getEnv(), c.getSystemName(), c.getConfFileName()));
                results.add(cm);
            }
            model.put("confList", results);
            model.put("env", config.getEnv());
            model.put("config", config);
            model.put("msg", "");
        } else {
            model.put("msg", "无操作权限");
            model.put("env", "");
            model.put("config", new Config());
        }

        return "config/index";
    }

    /**
     * 修改配置
     *
     * @return
     * @author yinjihuan
     */
    @PostMapping("/conf/update")
    @ResponseBody
    public ResponseResult<Boolean> update(@RequestBody List<NodeInfo> nodes, HttpServletRequest request) {
        return new AbstractControllerExecutor<Boolean>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.emptyListCheck(nodes);
            }

            @Override
            public Boolean executeService() throws ServiceException {
                return nodeService.update(nodes);
            }
        }.execute(nodes);
    }

    /**
     * 删除配置
     *
     * @param id
     * @return
     * @author yinjihuan
     */
    @PostMapping("/conf/remove")
    @ResponseBody
    public String remove(Integer id) {
        configService.removeConfig(id);
        return "success";
    }

    /**
     * 推送配置信息到指定的节点
     *
     * @param nodes
     * @return
     */
    @PostMapping("/conf/push")
    @ResponseBody
    public ResponseResult<Boolean> pushConf(@RequestBody List<NodeInfo> nodes) {
        return new AbstractControllerExecutor<Boolean>() {
            @Override
            public void checkParam() throws ServiceException {
                ParamCheckUtil.emptyListCheck(nodes);
            }

            @Override
            public Boolean executeService() throws ServiceException {
                return nodeService.pushConf(nodes);
            }
        }.execute(nodes);
    }
}
