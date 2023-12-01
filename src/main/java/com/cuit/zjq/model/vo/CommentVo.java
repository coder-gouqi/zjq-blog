package com.cuit.zjq.model.vo;

import com.cuit.zjq.model.domain.User;
import lombok.Data;

@Data
public class CommentVo {
    /**
     * 评论id
     */
    private String id;

    /**
     * 评论文章id
     */
    private String essayId;

    /**
     * 评论用户i
     */
    private User user;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复评论id
     */
    private String replyTo;

    /**
     * 创建时间
     */
    private String createTime;
}
