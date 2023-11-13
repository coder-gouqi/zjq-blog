package com.cuit.zjq.service.impl;


import com.cuit.zjq.mapper.FollowMapper;
import com.cuit.zjq.model.domain.Follow;
import com.cuit.zjq.model.dto.follow.FollowQueryRequest;
import com.cuit.zjq.model.dto.follow.FollowUpdateRequest;
import com.cuit.zjq.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
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
    public Boolean followUpdate(FollowUpdateRequest followUpdateRequest) {
        int result = 0;
        if (followUpdateRequest.getType() == OPERATE) {
            String id = UUID.randomUUID().toString().replace("-", "");
            followUpdateRequest.setId(id);
            result = followMapper.insert(followUpdateRequest);
        } else if (followUpdateRequest.getType() == CANCEL_OPERATE) {
            result = followMapper.delete(followUpdateRequest);
        }
        return result > 0;
    }

    @Override
    public List<Follow> followSelect(FollowQueryRequest followQueryRequest) {
        List<Follow> followList = followMapper.select(followQueryRequest);
        return followList;
    }
}




