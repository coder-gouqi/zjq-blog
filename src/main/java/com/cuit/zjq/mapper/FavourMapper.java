package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.model.domain.Favour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【favour】的数据库操作Mapper
 */
@Mapper
public interface FavourMapper {

    int insert(InteractionUpdateRequest interactionRequest);

    List<Favour> select(InteractionUpdateRequest interactionRequest);

    int delete(InteractionUpdateRequest interactionRequest);
}




