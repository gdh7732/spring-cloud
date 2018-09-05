package com.ocean.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ResponseResult jsonErrorHandler(ServiceException e) throws Exception {
        ResponseResult result = new ResponseResult();
        result.setErrorCode(e.getErrorEnum().getCode());
        result.setErrorMessage(e.getMessage());
        result.setData(null);
        result.setSuccess(false);
        return result;
    }
}
