package com.cuit.zjq.service.impl;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.mapper.FavourMapper;
import com.cuit.zjq.service.FavourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

import static com.cuit.zjq.common.Constant.CANCEL_OPERATE;
import static com.cuit.zjq.common.Constant.OPERATE;

/**
 * @description 针对表【favour】的数据库操作Service实现
 */
@Service
public class FavourServiceImpl implements FavourService {

    @Resource
    private FavourMapper favourMapper;

    @Override
    public Boolean favourUpdate(InteractionRequest interactionRequest) {
        int result = 0;
        if (interactionRequest.getType() == OPERATE) {
            String id = UUID.randomUUID().toString().replace("-", "");
            interactionRequest.setId(id);
            result = favourMapper.insert(interactionRequest);
        } else if (interactionRequest.getType() == CANCEL_OPERATE) {
            result = favourMapper.delete(interactionRequest);
        }
        return result > 0;
    }
}




