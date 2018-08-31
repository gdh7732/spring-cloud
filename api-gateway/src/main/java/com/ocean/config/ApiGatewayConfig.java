package com.ocean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guodahai
 * @version 2018/8/31 16:43
 */
@Configuration
public class ApiGatewayConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
