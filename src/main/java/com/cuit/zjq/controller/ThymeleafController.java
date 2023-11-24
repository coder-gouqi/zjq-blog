package com.cuit.zjq.controller;

import cn.hutool.core.util.StrUtil;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.user.UserLoginRequest;
import com.cuit.zjq.model.dto.user.UserRegisterRequest;
import com.cuit.zjq.service.CommentService;
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
public class ThymeleafController {

    @Resource
    private EssayService essayService;

    @Resource
    private CommentService commentService;

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

    @GetMapping("/detail/{id}")
    public String essaySelectById(Model model, @PathVariable("id") String essayId, HttpServletRequest request) {
        Essay essay = essayService.essaySelectById(essayId);
        model.addAttribute("essay", essay);
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        model.addAttribute("user", (User) obj);
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayCount", essayList.size());
        CommentQueryRequest commentQueryRequest = new CommentQueryRequest();
        commentQueryRequest.setEssayId(essayId);
        List<Comment> commentList = commentService.commentSelect(commentQueryRequest);
        model.addAttribute("commentList", commentList);
        return "blog_detail";
    }

    @GetMapping("/edit")
    public String essayAdd(Model model, HttpServletRequest request) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        model.addAttribute("user", (User) obj);
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "blog_edit";
    }


    @PostMapping("/register")
    public String userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        Boolean result = userService.userRegister(userRegisterRequest);
        if (result) {
            return "login";
        } else {
            return "login";
        }
    }

    @RequestMapping("/login")
    public String userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request, Model model) {
        String result = userService.userLogin(userLoginRequest, request);
        if (StrUtil.isNotBlank(result)) {
            model.addAttribute("message", "成功");
            return "blog_list";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request) {
        Boolean result = userService.userLogout(request);
        return "redirect:/";
    }

}
