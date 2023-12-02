package com.cuit.zjq.controller;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.service.ForwardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/forward")
public class ForwardController {

    @Resource
    private ForwardService forwardService;

    @PostMapping("/update")
    @ResponseBody
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
