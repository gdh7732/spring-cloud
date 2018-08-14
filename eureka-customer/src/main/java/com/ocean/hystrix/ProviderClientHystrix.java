package com.ocean.hystrix;

import com.ocean.api.ProviderClient;

/**
 * Provider服务调用熔断默认返回处理
 *
 * @author guodahai
 */
public class ProviderClientHystrix implements ProviderClient {

    @Override
    public String getMessage(String message) {
        return "hello";
    }
}
