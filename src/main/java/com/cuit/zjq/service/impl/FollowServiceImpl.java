package com.cuit.zjq.service.impl;


import com.cuit.zjq.mapper.FollowMapper;
import com.cuit.zjq.model.dto.follow.FollowRequest;
import com.cuit.zjq.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

import static com.cuit.zjq.common.Constant.CANCEL_OPERATE;
import static com.cuit.zjq.common.Constant.OPERATE;

/**
 * @description 针对表【follow】的数据库操作Service实现
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Resource
    private FollowMapper followMapper;

    @Override
    public Boolean followUpdate(FollowRequest followRequest) {
        int result = 0;
        if (followRequest.getType() == OPERATE) {
            String id = UUID.randomUUID().toString().replace("-", "");
            followRequest.setId(id);
            result = followMapper.insert(followRequest);
        } else if (followRequest.getType() == CANCEL_OPERATE) {
            result = followMapper.delete(followRequest);
        }
        return result > 0;
    }
}




