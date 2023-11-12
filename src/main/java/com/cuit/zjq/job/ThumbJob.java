package com.cuit.zjq.job;

import com.cuit.zjq.common.InteractionRequest;
import com.cuit.zjq.mapper.CommentMapper;
import com.cuit.zjq.mapper.EssayMapper;
import com.cuit.zjq.mapper.ThumbMapper;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.Thumb;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 点赞定时任务
 */
@Component
@EnableScheduling
public class ThumbJob {

    @Resource
    private EssayMapper essayMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private ThumbMapper thumbMapper;

    //每十分钟执行同步点赞数
    @Scheduled(cron = "0 */1 * * * ?")
    public void synchronizeThumb() {
        //查询所有文章
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayMapper.select(essayQueryRequest);
        //遍历所有id
        for (Essay essay : essayList) {
            String id = essay.getId();
            InteractionRequest interactionRequest = new InteractionRequest();
            interactionRequest.setEssayId(id);
            List<Thumb> thumbList = thumbMapper.select(interactionRequest);
            int thumbCount = thumbList.size();
            Essay essayForUpdate = essayMapper.selectById(id);
            essayForUpdate.setThumbNum(thumbCount);
            int updateById = essayMapper.updateById(essayForUpdate);
            if (updateById > 0) {
                System.out.println("更新文章" + id + "点赞数成功");
            }
        }
    }
}
