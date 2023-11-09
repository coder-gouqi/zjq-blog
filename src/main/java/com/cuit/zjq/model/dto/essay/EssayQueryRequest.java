package com.cuit.zjq.model.dto.essay;

import lombok.Data;

@Data
public class EssayQueryRequest {

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
     * 文章置顶
     */
    private Integer top;
}
