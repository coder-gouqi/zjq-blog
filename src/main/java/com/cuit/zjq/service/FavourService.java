package com.cuit.zjq.service;


import com.cuit.zjq.common.InteractionRequest;

/**
 * @description 针对表【favour】的数据库操作Service
 */
public interface FavourService {

    /**
     * 收藏/取消收藏
     *
     * @return
     */
    Boolean favourUpdate(InteractionRequest interactionRequest);
}
