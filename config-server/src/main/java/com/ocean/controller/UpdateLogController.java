package com.ocean.controller;

import com.ocean.service.ConfigService;
import com.ocean.service.UpdateLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class UpdateLogController {

    @Autowired
    private UpdateLogService updateLogService;

    @Autowired
    private ConfigService configService;

    @GetMapping("/logs/{id}")
    public String logPage(@PathVariable String id, Map<String, Object> model) {
        model.put("conf", configService.queryConfig(id));
        model.put("logs", updateLogService.queryUpdateLogList(id));
        return "conf/logs";
    }

}
