package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName essay
 */
@Data
public class Essay implements Serializable {
    /**
     * 文章id
     */
    private String id;

    /**
     * 用户id
     */
    private String user_id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章标签
     */
    private String tags;

    /**
     * 收藏数
     */
    private Integer favour_num;

    /**
     * 点赞数
     */
    private Integer thumb_num;

    /**
     * 评论数
     */
    private Integer comment_num;

    /**
     * 转发数
     */
    private Integer forward_num;

    /**
     * 文章置顶
     */
    private Integer top;

    /**
     * 逻辑删除
     */
    private Integer is_delete;

    private static final long serialVersionUID = 1L;


}