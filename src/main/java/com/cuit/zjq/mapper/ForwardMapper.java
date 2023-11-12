package com.cuit.zjq.mapper;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.model.domain.Forward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【forward】的数据库操作Mapper
 */
@Mapper
public interface ForwardMapper {

    int insert(InteractionRequest interactionRequest);

    List<Forward> select(InteractionRequest interactionRequest);

    int delete(InteractionRequest interactionRequest);
}




