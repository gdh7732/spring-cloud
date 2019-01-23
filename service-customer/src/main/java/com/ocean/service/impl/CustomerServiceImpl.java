package com.ocean.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ocean.feign.ProviderApi;
import com.ocean.service.CustomerService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author guodahai
 * @version 2018/8/29 18:08
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private ProviderApi providerApi;

    /**
     * 获取message
     * hystrixCommand 服务降级
     *
     * @param message
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public String getMessage(String message) {
        return providerApi.getMessage(message);
    }

    public String fallback(String message) {
        return "fallback" + message;
    }
}
