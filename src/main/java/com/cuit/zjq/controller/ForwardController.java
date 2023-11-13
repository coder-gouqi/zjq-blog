package com.cuit.zjq.controller;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.service.ForwardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/forward")
public class ForwardController {

    @Resource
    private ForwardService forwardService;

    @PostMapping("/update")
    public StatusResponse doForward(@RequestBody InteractionUpdateRequest interactionUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = forwardService.forwardUpdate(interactionUpdateRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
