package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName favour
 */
@Data
public class Favour implements Serializable {
    /**
     * 收藏id
     */
    private String id;

    /**
     * 文章id
     */
    private String essayId;

    /**
     * 用户id
     */
    private String userId;

    private static final long serialVersionUID = 1L;

}