package com.cuit.zjq.controller;

import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.dto.essay.EssayAddRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayUpdateRequest;
import com.cuit.zjq.service.EssayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/essay")
public class EssayController {
    @Resource
    private EssayService essayService;

    @PostMapping("/add")
    @ResponseBody
    public StatusResponse essayAdd(@RequestBody EssayAddRequest essayAddRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = essayService.essayAdd(essayAddRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    @ResponseBody
    public StatusResponse essayUpdate(@RequestBody EssayUpdateRequest essayUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = essayService.essayUpdate(essayUpdateRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/select")
    @ResponseBody
    public StatusResponse essaySelect(@RequestBody EssayQueryRequest essayQueryRequest) {
        StatusResponse statusResponse = new StatusResponse();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        if (essayList != null) {
            statusResponse.setData(essayList);
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setData(null);
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/delete")
    @ResponseBody
    public StatusResponse essayDelete(@RequestBody DeleteRequest deleteRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = essayService.essayDelete(deleteRequest);
        statusResponse.setData(result);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
