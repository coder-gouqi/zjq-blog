package com.cuit.zjq.mapper;

import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【essay】的数据库操作Mapper
 */
@Mapper

public interface EssayMapper {

    int insert(Essay essay);

    List<Essay> select(EssayQueryRequest essayQueryRequest);

    List<Essay> selectByPage(EssayQueryRequest essayQueryRequest);

    Essay selectById(String id);

    int deleteById(DeleteRequest deleteRequest);

    int updateById(Essay essay);

    List<Essay> selectTagsCount();
}




