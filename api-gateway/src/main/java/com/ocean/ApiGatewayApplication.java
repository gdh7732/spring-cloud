package com.ocean;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * @author guodahai
 */
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
