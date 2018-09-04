package com.ocean.service;

import com.ocean.domain.Config;

import java.util.List;

public interface ConfService {

    List<Config> listForPage(String env, String systemName, String fileName, String key, int page, int limit);

    List<Config> list(String env, String systemName, String fileName);

    List<Config> list(String env, String systemName);

    List<Config> list(String env);

    void save(Config config);

    Config get(String id);

    List<Config> get(String env, String systemName, String fileName, String key);

    void remove(String id);

    List<String> getNodes(String env, String systemName, String fileName);

}
