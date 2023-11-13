package com.cuit.zjq.service;


import com.cuit.zjq.model.domain.Follow;
import com.cuit.zjq.model.dto.follow.FollowQueryRequest;
import com.cuit.zjq.model.dto.follow.FollowUpdateRequest;

import java.util.List;

/**
 * @description 针对表【follow】的数据库操作Service
 */
public interface FollowService {
    /**
     * 关注/取消关注
     *
     * @return
     */
    Boolean followUpdate(FollowUpdateRequest followUpdateRequest);

    /**
     * 查看关注
     */
    List<Follow> followSelect(FollowQueryRequest followQueryRequest);
}
