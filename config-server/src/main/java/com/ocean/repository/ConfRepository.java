package com.ocean.repository;

import com.ocean.domain.Config;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Config> listForPage(String env, String systemName, String fileName, String key, int page, int limit) {
        Query query = new Query(Criteria.where("env").is(env));
        if (StringUtils.isNotBlank(systemName)) {
            query.addCriteria(Criteria.where("systemName").is(systemName));
        }
        if (StringUtils.isNotBlank(fileName)) {
            query.addCriteria(Criteria.where("confFileName").is(fileName));
        }
        if (StringUtils.isNotBlank(key)) {
            query.addCriteria(Criteria.where("key").is(key));
        }
        query.with(new Sort(Direction.DESC, "id"));
        return mongoTemplate.find(query, Config.class);
    }

    public List<Config> list(String env, String systemName, String fileName) {
        Query query = new Query(Criteria.where("env").is(env));
        query.addCriteria(Criteria.where("systemName").is(systemName));
        query.addCriteria(Criteria.where("confFileName").is(fileName));
        return mongoTemplate.find(query, Config.class);
    }

    public List<Config> list(String env, String systemName) {
        Query query = new Query(Criteria.where("env").is(env));
        query.addCriteria(Criteria.where("systemName").is(systemName));
        return mongoTemplate.find(query, Config.class);
    }

    public List<Config> list(String env) {
        Query query = new Query(Criteria.where("env").is(env));
        return mongoTemplate.find(query, Config.class);
    }

    public void save(Config config) {
        mongoTemplate.save(config);
    }

    public Config get(String id) {
        return mongoTemplate.findById(id, Config.class);
    }

    public void remove(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Config.class);
    }
}