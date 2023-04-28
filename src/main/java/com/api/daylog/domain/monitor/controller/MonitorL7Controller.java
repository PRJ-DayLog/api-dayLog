package com.api.daylog.domain.monitor.controller;

import com.api.daylog.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorL7Controller {

    @GetMapping("/check")
    public ApiResponse monitorL7Check() {
        return ApiResponse.ok();
    }
}
