package com.cuit.zjq.controller;

import cn.hutool.core.util.StrUtil;
import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.dto.comment.CommentAddRequest;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.comment.CommentUpdateRequest;
import com.cuit.zjq.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public StatusResponse commentAdd(@RequestBody CommentAddRequest commentAddRequest) {
        StatusResponse statusResponse = new StatusResponse();
        String commentId = commentService.commentAdd(commentAddRequest);
        if (StrUtil.isNotBlank(commentId)) {
            statusResponse.setData(commentId);
        }
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

    @PostMapping("/update")
    public StatusResponse commentUpdate(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = commentService.commentUpdate(commentUpdateRequest);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            return statusResponse;
        }
        statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        return statusResponse;
    }

    @GetMapping("/select")
    public StatusResponse commentSelect(@RequestBody CommentQueryRequest commentQueryRequest) {
        StatusResponse statusResponse = new StatusResponse();
        List<Comment> commentList = commentService.commentSelect(commentQueryRequest);
        if (commentList != null) {
            statusResponse.setData(commentList);
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            return statusResponse;
        }
        statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        return statusResponse;
    }

    @PostMapping("/delete")
    public StatusResponse commentDelete(@RequestBody DeleteRequest deleteRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = commentService.commentDelete(deleteRequest);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            return statusResponse;
        }
        statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        return statusResponse;
    }


}
