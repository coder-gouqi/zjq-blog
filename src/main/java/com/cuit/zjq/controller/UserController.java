package com.cuit.zjq.controller;

import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;
import com.cuit.zjq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
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
    @ResponseBody
    public StatusResponse userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        User user = userService.userLogin(userLoginRequest, request);
        if (user != null) {
            statusResponse.setData(user);
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    @ResponseBody
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
    @ResponseBody
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
