package com.ocean.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Feign接口
 *
 * @author guodahai
 */
@FeignClient(value = "provider", path = "/provider")
public interface ProviderApi {

    /**
     * 获取信息
     *
     * @param message
     * @return
     */
    @GetMapping(value = "queryInfo/{message}")
    String getMessage(@PathVariable("message") String message);

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

}
