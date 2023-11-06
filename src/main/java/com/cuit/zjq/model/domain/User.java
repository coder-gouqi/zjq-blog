package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户账号
     */
    private String user_account;

    /**
     * 用户密码
     */
    private String user_password;

    /**
     * 用户角色
     */
    private String user_role;

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

    /**
     * 逻辑删除
     */
    private Integer is_delete;

    private static final long serialVersionUID = 1L;

}