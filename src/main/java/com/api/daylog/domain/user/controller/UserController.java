package com.api.daylog.domain.user.controller;

import com.api.daylog.common.response.ApiResponse;
import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import com.api.daylog.domain.user.dto.response.UserResponse;
import com.api.daylog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/{version:v1.*}/user")
    public ApiResponse createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        UserResponse createUserResponse = userService.createUser(userCreateRequest);
        return ApiResponse.ok(createUserResponse);
    }
}
