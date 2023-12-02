package com.cuit.zjq.controller;

import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Follow;
import com.cuit.zjq.model.dto.follow.FollowQueryRequest;
import com.cuit.zjq.model.dto.follow.FollowUpdateRequest;
import com.cuit.zjq.service.FollowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class FollowController {

    @Resource
    private FollowService followService;

    @PostMapping("/follow/update")
    public StatusResponse doFollow(@RequestBody FollowUpdateRequest followUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = followService.followUpdate(followUpdateRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/follow/select")
    public StatusResponse followSelect(@RequestBody FollowQueryRequest followQueryRequest) {
        StatusResponse statusResponse = new StatusResponse();
        List<Follow> followList = followService.followSelect(followQueryRequest);
        if (followList != null) {
            statusResponse.setData(followList);
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setData(null);
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

}
