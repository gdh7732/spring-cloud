package com.ocean.model;

import com.ocean.domain.Config;

import java.util.List;

public class ConfigModel extends Config {
    private int page;
    private List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
