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
    private String follow_id;

    /**
     * 被关注者id
     */
    private String follower_id;

    private static final long serialVersionUID = 1L;

}