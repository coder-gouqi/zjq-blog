package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 针对表【thumb】的数据库操作Mapper
 */
@Mapper
public interface ThumbMapper {

    int insert(InteractionRequest interactionRequest);

    int delete(InteractionRequest interactionRequest);
}




