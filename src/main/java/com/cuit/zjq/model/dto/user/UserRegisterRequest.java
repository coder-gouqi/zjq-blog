package com.cuit.zjq.model.dto.user;

import lombok.Data;

@Data
public class UserRegisterRequest {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

}
