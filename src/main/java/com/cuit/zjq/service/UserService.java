package com.cuit.zjq.service;


import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description 针对表【user】的数据库操作Service
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    Boolean userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return
     */
    User userLogin(UserLoginRequest userLoginRequest,HttpServletRequest request);

    /**
     * 用户更新
     *
     * @param userUpdateRequest
     * @return
     */
    Boolean userUpdate(UserUpdateRequest userUpdateRequest);

    /**
     * 用户注销
     *
     * @return
     */
    Boolean userLogout(HttpServletRequest request);


    List<User> selectUser();
}
