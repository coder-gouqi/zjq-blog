package com.cuit.zjq.service.impl;


import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.cuit.zjq.mapper.UserMapper;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;
import com.cuit.zjq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.cuit.zjq.common.Constant.USER_LOGIN_STATE;

/**
 * @description 针对表【user】的数据库操作Service实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean userRegister(UserRegisterRequest userRegisterRequest) {
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String id = UUID.randomUUID().toString().replace("-", "");
        User user = new User();
        user.setId(id);
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserRole("user");
        user.setIsDelete(0);
        int result = userMapper.insert(user);
        return result > 0;
    }

    @Override
    public User userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request) {
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        User user = userMapper.userLogin(userAccount, userPassword);
        if (ObjectUtil.isNotEmpty(user)) {
            request.getSession().setAttribute(USER_LOGIN_STATE, user);
            System.out.println(user);
            return user;
        }
        return null;
    }

    @Override
    public Boolean userUpdate(UserUpdateRequest userUpdateRequest) {
        int result = userMapper.updateById(userUpdateRequest);
        return result > 0;
    }

    @Override
    public Boolean userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return true;
    }

    @Override
    public List<User> selectUser() {
        List<User> userList = userMapper.select();
        return userList;
    }
}




