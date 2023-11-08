package com.cuit.zjq.model.dto.comment;

import lombok.Data;

@Data
public class CommentQueryRequest {

    /**
     * 评论文章id
     */
    private String essayId;

    /**
     * 评论用户id
     */
    private String userId;

    /**
     * 回复评论id
     */
    private String replyTo;
}
