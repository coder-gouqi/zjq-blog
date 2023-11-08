package com.cuit.zjq.model.dto.comment;

import lombok.Data;

@Data
public class CommentUpdateRequest {

    /**
     * 评论id
     */
    private String id;

    /**
     * 评论内容
     */
    private String content;

}
