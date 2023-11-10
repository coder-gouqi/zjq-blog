package com.cuit.zjq.service;


import com.cuit.zjq.common.InteractionRequest;

/**
 * @description 针对表【forward】的数据库操作Service
 */
public interface ForwardService {
    /**
     * 转发/取消转发
     *
     * @return
     */
    Boolean forwardUpdate(InteractionRequest interactionRequest);
}
