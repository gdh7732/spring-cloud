package com.ocean.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider", path = "/provider")
public interface ProviderClient {

    @GetMapping(value = "queryInfo/{message}")
    String getMessage(@PathVariable("message") String message);
}
