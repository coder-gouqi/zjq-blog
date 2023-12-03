package com.cuit.zjq.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.vo.CommentVo;
import com.cuit.zjq.service.CommentService;
import com.cuit.zjq.service.EssayService;
import com.cuit.zjq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ThymeleafController {

    @Resource
    private EssayService essayService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    private int pageSize = 3;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/list/page")
    public String essaySelect(Model model, @RequestParam("currentPage") int currentPage) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        essayQueryRequest.setCurrentPage(currentPage * pageSize);
        essayQueryRequest.setPageSize(pageSize);
        List<Essay> essayPageList = essayService.essaySelectByPage(essayQueryRequest);
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayPageList);
        model.addAttribute("essayCount", essayList.size());
        model.addAttribute("tagsCount", essayService.selectTagsCount());
        model.addAttribute("pre", Math.max(currentPage - 1, 0));
        model.addAttribute("next", Math.min(currentPage + 1, essayList.size() % pageSize == 0 ? essayList.size() / pageSize - 1 : essayList.size() / pageSize));
        model.addAttribute("end", essayList.size() % pageSize == 0 ? essayList.size() / pageSize - 1 : essayList.size() / pageSize);
        return "blog_list";
    }

    @GetMapping("/list")
    public String essaySelect(Model model) {
        int currentPage = 0;
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        essayQueryRequest.setCurrentPage(0);
        essayQueryRequest.setPageSize(pageSize);
        List<Essay> essayPageList = essayService.essaySelectByPage(essayQueryRequest);
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayPageList);
        model.addAttribute("essayCount", essayList.size());
        model.addAttribute("tagsCount", essayService.selectTagsCount());
        model.addAttribute("pre", 0);
        model.addAttribute("next", Math.min(currentPage + 1, essayList.size() % pageSize == 0 ? essayList.size() / pageSize - 1 : essayList.size() / pageSize));
        model.addAttribute("end", essayList.size() % pageSize == 0 ? essayList.size() / pageSize - 1 : essayList.size() / pageSize);
        return "blog_list";
    }

    @GetMapping("/issue")
    public String essayIssue() {
        return "blog_issue";
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request) {
        Boolean result = userService.userLogout(request);
        return "login";
    }

    @GetMapping("/edit")
    public String essayEdit(Model model, @RequestParam("id") String essayId) {
        Essay essay = essayService.essaySelectById(essayId);
        model.addAttribute("essay", essay);
        return "blog_edit";
    }

    @GetMapping("/comment/delete")
    public String deleteComment(@RequestParam("id") String commentId) {
        Comment comment = commentService.selectById(commentId);
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setId(commentId);
        Boolean result = commentService.commentDelete(deleteRequest);
        return "redirect:/detail/" + comment.getEssayId();
    }

    @GetMapping("/detail/{id}")
    public String essaySelectById(Model model, @PathVariable("id") String essayId) {
        Essay essay = essayService.essaySelectById(essayId);
        model.addAttribute("essay", essay);
        User essayUser = userService.selectById(essay.getUserId());
        model.addAttribute("user", essayUser);
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        essayQueryRequest.setCurrentPage(0);
        essayQueryRequest.setPageSize(pageSize);
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayCount", essayList.size());
        model.addAttribute("tagsCount", essayService.selectTagsCount());
        CommentQueryRequest commentQueryRequest = new CommentQueryRequest();
        commentQueryRequest.setEssayId(essayId);
        List<Comment> commentList = commentService.commentSelect(commentQueryRequest);
        List<User> userList = userService.selectUser();
        ArrayList<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVo commentVo = new CommentVo();
            BeanUtil.copyProperties(comment, commentVo);
            for (User user : userList)
                if (user.getId().equals(comment.getUserId())) {
                    commentVo.setUser(user);
                }
            commentVoList.add(commentVo);
        }
        model.addAttribute("commentList", commentVoList);
        return "blog_detail";
    }
}