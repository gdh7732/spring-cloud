package com.ocean.controller;

import com.ocean.api.ProviderClient;
import com.ocean.common.ControllerExecutor;
import com.ocean.common.ResponseResult;
import com.ocean.common.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private ProviderClient providerClient;

    @GetMapping("queryInfo/{message}")
    public ResponseResult<String> queryInfo(@PathVariable("message") String message) {
        return new ControllerExecutor<String, String>(message) {
            @Override
            public void checkParam() throws ServiceException {
            }

            @Override
            public String executeService(String... param) throws ServiceException {
                return providerClient.getMessage(param[0]);
            }
        }.execute(message);
    }
}
