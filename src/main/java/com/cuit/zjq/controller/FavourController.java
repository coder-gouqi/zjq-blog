package com.cuit.zjq.controller;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.service.FavourService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/favour")
public class FavourController {

    @Resource
    private FavourService favourService;

    @PostMapping("/update")
    @ResponseBody
    public StatusResponse doFavour(@RequestBody InteractionUpdateRequest interactionUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = favourService.favourUpdate(interactionUpdateRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
