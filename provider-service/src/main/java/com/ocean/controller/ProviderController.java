package com.ocean.controller;

import com.ocean.common.ControllerExecutor;
import com.ocean.common.ResponseResult;
import com.ocean.common.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("queryInfo")
    public ResponseResult<String> queryInfo(String message) {
        return new ControllerExecutor<String, String>(message) {
            @Override
            public void checkParam() throws ServiceException {
            }

            @Override
            public String executeService(String... param) throws ServiceException {
                return param[0];
            }
        }.execute(message);
    }
}
