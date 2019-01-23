package com.ocean.controller;

import com.ocean.common.AbstractControllerExecutor;
import com.ocean.common.ResponseResult;
import com.ocean.common.ServiceException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 提供服务案例
 *
 * @author guodahai
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @GetMapping("queryInfo/{message}")
    public ResponseResult<String> queryInfo(@PathVariable("message") String message) {
        return new AbstractControllerExecutor<String>() {
            @Override
            public void checkParam() throws ServiceException {
            }

            @Override
            public String executeService() throws ServiceException {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return message;
            }
        }.execute(message);
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return file.getName();
    }
}
