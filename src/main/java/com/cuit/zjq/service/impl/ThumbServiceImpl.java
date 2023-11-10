package com.cuit.zjq.service.impl;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.mapper.ThumbMapper;
import com.cuit.zjq.service.ThumbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

import static com.cuit.zjq.common.Constant.CANCEL_OPERATE;
import static com.cuit.zjq.common.Constant.OPERATE;

/**
 * @description 针对表【thumb】的数据库操作Service实现
 */
@Service
public class ThumbServiceImpl implements ThumbService {

    @Resource
    private ThumbMapper thumbMapper;

    @Override
    public Boolean thumbUpdate(InteractionRequest interactionRequest) {
        int result = 0;
        if (interactionRequest.getType() == OPERATE) {
            String id = UUID.randomUUID().toString().replace("-", "");
            interactionRequest.setId(id);
            result = thumbMapper.insert(interactionRequest);
        } else if (interactionRequest.getType() == CANCEL_OPERATE) {
            result = thumbMapper.delete(interactionRequest);
        }
        return result > 0;
    }
}




