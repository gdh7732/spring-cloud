package com.ocean.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign接口
 *
 * @author guodahai
 */
@FeignClient(value = "provider", path = "/provider")
public interface ProviderClient {

    /**
     * 获取信息
     *
     * @param message
     * @return
     */

    @GetMapping(value = "queryInfo/{message}")
    String getMessage(@PathVariable("message") String message);
}
