package com.ocean.service;

import com.ocean.model.NodeInfo;

import java.util.List;

public interface NodeService {

    Boolean pushConf(List<NodeInfo> nodes);

    Boolean update(List<NodeInfo> nodes);
}
