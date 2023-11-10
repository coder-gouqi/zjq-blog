package com.cuit.zjq.mapper;


import com.cuit.zjq.model.dto.follow.FollowRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 针对表【follow】的数据库操作Mapper
 */
@Mapper
public interface FollowMapper {

    int insert(FollowRequest followRequest);

    int delete(FollowRequest followRequest);
}




