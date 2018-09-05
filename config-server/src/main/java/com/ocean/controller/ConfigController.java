package com.ocean.controller;

import com.ocean.common.LoginUserInfoUtils;
import com.ocean.common.ResponseData;
import com.ocean.domain.Config;
import com.ocean.domain.UpdateLog;
import com.google.common.collect.Lists;
import com.ocean.model.ConfigModel;
import com.ocean.model.NodeInfo;
import com.ocean.common.Constant;
import com.ocean.common.EnvConstants;
import com.ocean.util.CommonUtil;
import com.ocean.service.ConfigService;
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

import java.util.Date;
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

    /**
     * 配置列表页面
     *
     * @param config
     * @param model
     * @return
     * @author yinjihuan
     */
    @GetMapping("/")
    public Object index(ConfigModel config, Map<String, Object> model, HttpServletRequest request) {
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
            if (config.getPage() == 0) config.setPage(1);
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
    public Object update(@RequestBody List<NodeInfo> nodes, HttpServletRequest request) {
        if (nodes != null) {
            for (NodeInfo node : nodes) {
                Object oldValue;
                Config config = configService.queryConfig(node.getId());
                oldValue = config.getValue();
                config.setValue(node.getValue());
                config.setModifyDate(new Date());
                configService.saveConfig(config);

                //添加修改日志
                UpdateLog log = UpdateLog.builder().updateObjId(node.getId())
                        .updateTime(new Date())
                        .oldValue(oldValue)
                        .newValue(node.getValue())
                        .username(request.getSession().getAttribute("login_user_name").toString())
                        .updateDesc(node.getDesc()).build();
                updateLogService.saveUpdateLog(log);
                // 值是根据推送节点传来的，只需要修改一次即可，推送就根据节点数量来
                break;
            }

            for (NodeInfo node : nodes) {
                Config config = configService.queryConfig(node.getId());
                //修改zk中的节点的值，告诉客户端值有修改
                List<String> clients = CommonUtil.getZkClient().getClientServers(config.getEnv(), config.getSystemName());
                for (String client : clients) {
                    if (client.split("&")[0].equals(node.getNode()) && client.split("&")[1].equals(config.getConfFileName())) {
                        CommonUtil.getZkClient().setValue(
                                CommonUtil.buildPath(Constant.ZK_ROOT_PATH, config.getEnv(),
                                        config.getSystemName(), client), config.getValue());
                    }
                }
            }
        }

        return ResponseData.ok();
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
    public Object remove(String id) {
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
    public Object pushConf(@RequestBody List<NodeInfo> nodes) {
        if (nodes != null) {
            for (NodeInfo node : nodes) {
                Config config = configService.queryConfig(node.getId());
                //修改zk中的节点的值，告诉客户端值有修改
                List<String> clients = CommonUtil.getZkClient().getClientServers(config.getEnv(), config.getSystemName());
                for (String client : clients) {
                    if (client.split("&")[0].equals(node.getNode()) && client.split("&")[1].equals(config.getConfFileName())) {
                        CommonUtil.getZkClient().setValue(
                                CommonUtil.buildPath(Constant.ZK_ROOT_PATH, config.getEnv(),
                                        config.getSystemName(), client), config.getValue());
                    }
                }
            }
        }
        return ResponseData.ok();
    }
}
