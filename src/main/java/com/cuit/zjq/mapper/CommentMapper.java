package com.cuit.zjq.mapper;

import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description 针对表【comment】的数据库操作Mapper
 */
@Mapper
public interface CommentMapper {

    int insert(Comment comment);

    List<Comment> select();

    Comment selectById(String id);

    int deleteById(DeleteRequest deleteRequest);

    int updateById(Comment comment);

}




