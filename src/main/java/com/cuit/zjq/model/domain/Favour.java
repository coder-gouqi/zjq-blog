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
    private String essay_id;

    /**
     * 用户id
     */
    private String user_id;

    private static final long serialVersionUID = 1L;

}