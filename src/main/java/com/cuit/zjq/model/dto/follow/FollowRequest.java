package com.cuit.zjq.model.dto.follow;

import lombok.Data;

@Data
public class FollowRequest {
    /**
     * id
     */
    private String id;

    /**
     * 关注者id
     */
    private String followId;

    /**
     * 被关注者id
     */
    private String followerId;

    /**
     *  互动类型，操作0，取消操作1
     */
    private int type;
}
