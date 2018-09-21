package com.ocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * @author guodahai
 */
@EnableSwagger2Doc
@EnableFeignClients(basePackages = "com.ocean.api")
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
