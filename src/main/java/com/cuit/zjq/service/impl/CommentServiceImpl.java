package com.cuit.zjq.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.mapper.CommentMapper;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.dto.comment.CommentAddRequest;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.comment.CommentUpdateRequest;
import com.cuit.zjq.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description 针对表【comment】的数据库操作Service实现
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Boolean commentAdd(CommentAddRequest commentAddRequest) {
        Comment comment = new Comment();
        BeanUtil.copyProperties(commentAddRequest, comment);
        String id = UUID.randomUUID().toString().replace("-", "");
        comment.setId(id);
        comment.setIsDelete(0);
        int insert = commentMapper.insert(comment);
        return insert > 0;
    }

    @Override
    public Boolean commentUpdate(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentMapper.selectById(commentUpdateRequest.getId());
        BeanUtil.copyProperties(commentUpdateRequest, comment);
        int result = commentMapper.updateById(comment);
        return result > 0;
    }

    @Override
    public List<Comment> commentSelect(CommentQueryRequest commentQueryRequest) {
        List<Comment> commentList = commentMapper.select(commentQueryRequest);
        return commentList;
    }

    @Override
    public Boolean commentDelete(DeleteRequest deleteRequest) {
        int delete = commentMapper.deleteById(deleteRequest);
        return delete > 0;
    }

    @Override
    public Comment selectById(String id) {
        Comment comment = commentMapper.selectById(id);
        return comment;
    }
}




