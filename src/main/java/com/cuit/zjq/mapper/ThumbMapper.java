package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.model.domain.Thumb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【thumb】的数据库操作Mapper
 */
@Mapper
public interface ThumbMapper {

    int insert(InteractionUpdateRequest interactionRequest);

    List<Thumb> select(InteractionUpdateRequest interactionRequest);

    int delete(InteractionUpdateRequest interactionRequest);
}




