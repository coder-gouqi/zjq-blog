package com.cuit.zjq.service;


import com.cuit.zjq.common.InteractionUpdateRequest;

/**
 * @description 针对表【thumb】的数据库操作Service
 */
public interface ThumbService {
    /**
     * 点赞/取消点赞
     *
     * @return
     */
    Boolean thumbUpdate(InteractionUpdateRequest interactionRequest);
}
