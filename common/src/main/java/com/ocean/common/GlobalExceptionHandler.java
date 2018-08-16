package com.ocean.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author guodahai
 * @version 2018/8/16 15:23
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ResponseResult serviceExceptionHandler(ServiceException e) {
        ResponseResult result = new ResponseResult();
        result.setErrorCode(e.getErrorCode().getCode());
        result.setErrorMessage(e.getMessage());
        result.setData(null);
        result.setSuccess(false);
        return result;
    }
}
