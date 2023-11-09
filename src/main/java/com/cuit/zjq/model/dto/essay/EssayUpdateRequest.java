package com.cuit.zjq.model.dto.essay;

import lombok.Data;

@Data
public class EssayUpdateRequest {

    /**
     * 文章id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

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
    private Integer favourNum;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 转发数
     */
    private Integer forwardNum;

    /**
     * 文章置顶
     */
    private Integer top;

}
