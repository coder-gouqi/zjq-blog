package com.cuit.zjq.controller;

import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.model.dto.user.UserUpdateRequest;
import com.cuit.zjq.service.EssayService;
import com.cuit.zjq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.cuit.zjq.common.Constant.USER_LOGIN_STATE;

@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private EssayService essayService;

    @RequestMapping("/user")
    public String login(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute(USER_LOGIN_STATE) != null) {
            EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
            List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
            model.addAttribute("essayList", essayList);
            model.addAttribute("essayCount", essayList.size());
            return "blog_list";
        }
        return "login";
    }

    @PostMapping("/user/register")
    public String userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        Boolean result = userService.userRegister(userRegisterRequest);
        if (result) {
            return "login";
        } else {
            return "login";
        }
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request, Model model) {
        User result = userService.userLogin(userLoginRequest, request);
        if (result != null) {
            model.addAttribute("message", "成功");
            return result;
        } else {
            return null;
        }
    }

    @GetMapping("/user/logout")
    public String userLogout(HttpServletRequest request) {
        Boolean result = userService.userLogout(request);
        return "redirect:/user/";
    }


    @PostMapping("/user/update")
    public StatusResponse userUpdate(@RequestBody UserUpdateRequest userUpdateRequest) {
        StatusResponse statusResponse = new StatusResponse();
        Boolean result = userService.userUpdate(userUpdateRequest);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

}
