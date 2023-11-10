package com.cuit.zjq.controller;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.service.FavourService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/favour")
public class FavourController {

    @Resource
    private FavourService favourService;

    @PostMapping("/update")
    public StatusResponse doFavour(@RequestBody InteractionRequest interactionRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = favourService.favourUpdate(interactionRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
