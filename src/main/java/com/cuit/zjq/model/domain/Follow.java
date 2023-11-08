package com.cuit.zjq.model.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName follow
 */
@Data
public class Follow implements Serializable {
    /**
     * 关注id
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

    private static final long serialVersionUID = 1L;

}