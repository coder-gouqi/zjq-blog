package com.cuit.zjq.controller;

import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.dto.comment.CommentAddRequest;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.comment.CommentUpdateRequest;
import com.cuit.zjq.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/comment/add")
    public String commentAdd(@RequestBody CommentAddRequest commentAddRequest) {
        Boolean result = commentService.commentAdd(commentAddRequest);
        return "blog_list";
    }

    @PostMapping("/comment/update")
    public StatusResponse commentUpdate(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = commentService.commentUpdate(commentUpdateRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/comment/select")
    public StatusResponse commentSelect(@RequestBody CommentQueryRequest commentQueryRequest) {
        StatusResponse statusResponse = new StatusResponse();
        List<Comment> commentList = commentService.commentSelect(commentQueryRequest);
        if (commentList != null) {
            statusResponse.setData(commentList);
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setData(null);
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/comment/delete")
    public StatusResponse commentDelete(@RequestBody DeleteRequest deleteRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = commentService.commentDelete(deleteRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
