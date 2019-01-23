package com.ocean.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocean.common.AbstractControllerExecutor;
import com.ocean.common.ErrorCodeEnum;
import com.ocean.common.ResponseResult;
import com.ocean.common.ServiceException;
import com.ocean.service.CustomerService;

/**
 * 消费案例
 *
 * @author guodahai
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("queryInfo/{message}")
    public ResponseResult<String> queryInfo(@PathVariable("message") String message) {
        return new AbstractControllerExecutor<String>() {
            @Override
            public void checkParam() throws ServiceException {
                if (StringUtils.isEmpty(message)) {
                    throw new ServiceException(ErrorCodeEnum.P01);
                }
            }

            @Override
            public String executeService() throws ServiceException {
                return customerService.getMessage(message);
            }
        }.execute(message);
    }
}
