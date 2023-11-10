package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 针对表【forward】的数据库操作Mapper
 */
@Mapper
public interface ForwardMapper {

    int insert(InteractionRequest interactionRequest);

    int delete(InteractionRequest interactionRequest);
}




