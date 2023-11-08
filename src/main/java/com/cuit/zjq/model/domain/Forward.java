package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName forward
 */
@Data
public class Forward implements Serializable {
    /**
     * 转发id
     */
    private String id;

    /**
     * 转发文章id
     */
    private String essayId;

    /**
     * 转发用户id
     */
    private String userId;

    private static final long serialVersionUID = 1L;

}