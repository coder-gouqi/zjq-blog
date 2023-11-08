package com.cuit.zjq.model.dto.comment;

import lombok.Data;

@Data
public class CommentAddRequest {
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
}
