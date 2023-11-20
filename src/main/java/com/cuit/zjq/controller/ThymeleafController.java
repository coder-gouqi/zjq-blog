package com.cuit.zjq.controller;

import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.service.EssayService;
import com.cuit.zjq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ThymeleafController {

    @Resource
    private EssayService essayService;

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public String essaySelect(Model model) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "blog_list";
    }


    @RequestMapping("/")
    public String login(Model model) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "login";
    }

    @GetMapping("/detail/{id}")
    public String essaySelectById(Model model, @PathVariable("id") String essayId) {
        Essay essay = essayService.essaySelectById(essayId);
        model.addAttribute("essay", essay);
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayCount", essayList.size());
        return "blog_detail";
    }

    @GetMapping("/edit")
    public String essayAdd(Model model) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "blog_edit";
    }


    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        String result = userService.userLogin(userLoginRequest, request);
        return "redirect:/list";
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request) {
        Boolean result = userService.userLogout(request);
        return "redirect:/";
    }
}