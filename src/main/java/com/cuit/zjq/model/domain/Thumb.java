package com.cuit.zjq.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName thumb
 */
@Data
public class Thumb implements Serializable {
    /**
     * 点赞id
     */
    private String id;

    /**
     * 评论文章id
     */
    private String essayId;

    /**
     * 评论用户id
     */
    private String userId;

    private static final long serialVersionUID = 1L;

}