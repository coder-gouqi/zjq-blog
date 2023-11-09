package com.cuit.zjq.model.dto.user;

import lombok.Data;

@Data
public class UserUpdateRequest {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 爱好
     */
    private String hobby;
}
