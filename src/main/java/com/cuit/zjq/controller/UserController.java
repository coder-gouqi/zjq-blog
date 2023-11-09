package com.cuit.zjq.controller;

import cn.hutool.core.util.StrUtil;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;
import com.cuit.zjq.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public StatusResponse userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = userService.userRegister(userRegisterRequest);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/login")
    public StatusResponse userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        String result = userService.userLogin(userLoginRequest, request);
        if (StrUtil.isNotBlank(result)) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    public StatusResponse userUpdate(@RequestBody UserUpdateRequest userUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = userService.userUpdate(userUpdateRequest);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/logout")
    public StatusResponse userLogout(HttpServletRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = userService.userLogout(request);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
