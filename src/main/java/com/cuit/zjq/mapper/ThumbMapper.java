package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.Thumb;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【thumb】的数据库操作Mapper
 */
@Mapper
public interface ThumbMapper {

    int insert(InteractionRequest interactionRequest);

    List<Thumb> select(InteractionRequest interactionRequest);

    int delete(InteractionRequest interactionRequest);
}




