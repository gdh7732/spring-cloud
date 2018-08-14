package com.ocean.controller;

import com.ocean.api.ProviderClient;
import com.ocean.common.AbstractControllerExecutor;
import com.ocean.common.ResponseResult;
import com.ocean.common.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消费案例
 *
 * @author guodahai
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private ProviderClient providerClient;

    @GetMapping("queryInfo/{message}")
    public ResponseResult<String> queryInfo(@PathVariable("message") String message) {
        return new AbstractControllerExecutor<String, String>(message) {
            @Override
            public void checkParam() throws ServiceException {
            }

            @Override
            public String executeService() throws ServiceException {
                return providerClient.getMessage(message);
            }
        }.execute(message);
    }
}
