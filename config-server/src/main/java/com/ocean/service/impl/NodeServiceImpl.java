package com.ocean.service.impl;

import com.google.common.collect.Lists;
import com.ocean.common.ParamCheckUtil;
import com.ocean.domain.Config;
import com.ocean.domain.UpdateLog;
import com.ocean.model.NodeInfo;
import com.ocean.service.ConfigService;
import com.ocean.service.NodeService;
import com.ocean.service.UpdateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {

    @Resource
    private ConfigService configService;
    @Resource
    private UpdateLogService updateLogService;

    @Override
    public Boolean pushConf(List<NodeInfo> nodes) {
        ParamCheckUtil.emptyListCheck(nodes);
        for (NodeInfo node : nodes) {
            Config config = configService.queryConfig(node.getId());
            //修改zk中的节点的值，告诉客户端值有修改
//            List<String> clients = CommonUtil.getZkClient().getClientServers(config.getEnv(), config.getSystemName());
            List<String> clients = Lists.newArrayList();
            for (String client : clients) {
                if (client.split("&")[0].equals(node.getNode()) && client.split("&")[1].equals(config.getConfFileName())) {
//                    CommonUtil.getZkClient().setValue(
//                            CommonUtil.buildPath(Constant.ZK_ROOT_PATH, config.getEnv(),
//                                    config.getSystemName(), client), config.getValue());
                }
            }
        }
        return true;
    }

    @Override
    public Boolean update(List<NodeInfo> nodes) {
        ParamCheckUtil.emptyListCheck(nodes);
        for (NodeInfo node : nodes) {
            Config config = configService.queryConfig(node.getId());
            config.setValue(node.getValue());
            config.setGmtModify(new Date());
            configService.saveConfig(config);
            UpdateLog log = new UpdateLog("", node.getId(), config.getValue(), node.getValue(), node.getDesc());
            updateLogService.saveUpdateLog(log);
            // 值是根据推送节点传来的，只需要修改一次即可，推送就根据节点数量来
            break;
        }
        return pushConf(nodes);
    }
}
