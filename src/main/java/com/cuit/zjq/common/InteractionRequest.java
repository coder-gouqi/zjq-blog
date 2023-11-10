package com.cuit.zjq.common;

import lombok.Data;

@Data
public class InteractionRequest {

    /**
     * id
     */
    private String id;

    /**
     * 文章id
     */
    private String essayId;

    /**
     * 用户id
     */
    private String userId;

    /**
     *  互动类型，操作0，取消操作1
     */
    private int type;
}
