package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName comment
 */
@Data
public class Comment implements Serializable {
    /**
     * 评论id
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

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复评论id
     */
    private String replyTo;

    /**
     * 逻辑删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

}