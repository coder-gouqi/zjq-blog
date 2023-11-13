package com.cuit.zjq.model.dto.follow;

import lombok.Data;

@Data
public class FollowQueryRequest {
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
}
