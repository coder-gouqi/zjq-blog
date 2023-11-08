package com.cuit.zjq.service;


import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.dto.comment.CommentAddRequest;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.comment.CommentUpdateRequest;

import java.util.List;

/**
 * @description 针对表【comment】的数据库操作Service
 */
public interface CommentService {
    /**
     * 发布评论
     *
     * @return
     */
    String commentAdd(CommentAddRequest commentAddRequest);

    /**
     * 修改评论
     *
     * @return
     */
    Boolean commentUpdate(CommentUpdateRequest commentUpdateRequest);

    /**
     * 查看评论
     */
    List<Comment> commentSelect(CommentQueryRequest commentQueryRequest);

    /**
     * 删除评论
     */
    Boolean commentDelete(DeleteRequest deleteRequest);
}
