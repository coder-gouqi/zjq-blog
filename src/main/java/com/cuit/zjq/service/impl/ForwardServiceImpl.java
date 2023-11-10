package com.cuit.zjq.service.impl;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.mapper.ForwardMapper;
import com.cuit.zjq.service.ForwardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

import static com.cuit.zjq.common.Constant.CANCEL_OPERATE;
import static com.cuit.zjq.common.Constant.OPERATE;

/**
 * @description 针对表【forward】的数据库操作Service实现
 */
@Service
public class ForwardServiceImpl implements ForwardService {

    @Resource
    private ForwardMapper forwardMapper;

    @Override
    public Boolean forwardUpdate(InteractionRequest interactionRequest) {
        int result = 0;
        if (interactionRequest.getType() == OPERATE) {
            String id = UUID.randomUUID().toString().replace("-", "");
            interactionRequest.setId(id);
            result = forwardMapper.insert(interactionRequest);
        } else if (interactionRequest.getType() == CANCEL_OPERATE) {
            result = forwardMapper.delete(interactionRequest);
        }
        return result > 0;
    }
}




