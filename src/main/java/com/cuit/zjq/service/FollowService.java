package com.cuit.zjq.service;


import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.model.dto.follow.FollowRequest;

/**
 * @description 针对表【follow】的数据库操作Service
 */
public interface FollowService {
    /**
     * 关注/取消关注
     *
     * @return
     */
    Boolean followUpdate(FollowRequest followRequest);
}
