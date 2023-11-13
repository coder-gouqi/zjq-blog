package com.cuit.zjq.mapper;


import com.cuit.zjq.model.domain.Follow;
import com.cuit.zjq.model.dto.follow.FollowQueryRequest;
import com.cuit.zjq.model.dto.follow.FollowUpdateRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【follow】的数据库操作Mapper
 */
@Mapper
public interface FollowMapper {

    int insert(FollowUpdateRequest followUpdateRequest);

    List<Follow> select(FollowQueryRequest followQueryRequest);

    int delete(FollowUpdateRequest followUpdateRequest);
}




