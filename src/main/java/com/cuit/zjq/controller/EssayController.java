package com.cuit.zjq.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.common.StatusResponse;
import com.cuit.zjq.common.StatusResponseCode;
import com.cuit.zjq.model.domain.Comment;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.User;
import com.cuit.zjq.model.dto.comment.CommentQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayAddRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayUpdateRequest;
import com.cuit.zjq.model.vo.CommentVo;
import com.cuit.zjq.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.cuit.zjq.common.Constant.USER_LOGIN_STATE;

@Controller
@RequestMapping("/")
public class EssayController {

    @Resource
    private UserService userService;

    @Resource
    private EssayService essayService;

    @Resource
    private CommentService commentService;

    @Resource
    private ThumbService thumbService;

    @Resource
    private ForwardService forwardService;

    @Resource
    private FavourService favourService;

    @PostMapping("/essay/add")
    public String essayAdd(@RequestBody EssayAddRequest essayAddRequest) {
        Boolean result = essayService.essayAdd(essayAddRequest);
        return "blog_list";
    }

    @GetMapping("/essay/edit")
    public String essayAdd(Model model, HttpServletRequest request) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        model.addAttribute("user", (User) obj);
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "blog_edit";
    }

    @GetMapping("/essay/detail/{id}")
    public String essaySelectById(Model model, @PathVariable("id") String essayId, HttpServletRequest request) {
//        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
//        User LoginUser = (User) obj;
//        model.addAttribute("user", LoginUser);
        Essay essay = essayService.essaySelectById(essayId);
        model.addAttribute("essay", essay);
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayCount", essayList.size());
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

    @RequestMapping("/essay/delete")
    public String essayDelete(@RequestBody DeleteRequest deleteRequest) {
        Boolean result = essayService.essayDelete(deleteRequest);
        return "redirect:/list";
    }

    @PostMapping("/essay/update")
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

    @GetMapping("/essay/list")
    public String essaySelect(Model model) {
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayService.essaySelect(essayQueryRequest);
        model.addAttribute("essayList", essayList);
        model.addAttribute("essayCount", essayList.size());
        return "blog_list";
    }

    @PostMapping("/essay/thumb/update")
    public String doThumb(@RequestBody InteractionUpdateRequest interactionUpdateRequest) {
        Boolean result = thumbService.thumbUpdate(interactionUpdateRequest);
        return "blog_list";
    }

    @PostMapping("/essay/forward/update")
    public String doForward(@RequestBody InteractionUpdateRequest interactionUpdateRequest) {
        Boolean result = forwardService.forwardUpdate(interactionUpdateRequest);
        return "blog_list";
    }

    @PostMapping("/essay/favour/update")
    public String doFavour(@RequestBody InteractionUpdateRequest interactionUpdateRequest) {
        Boolean result = favourService.favourUpdate(interactionUpdateRequest);
        return "blog_list";
    }
}
