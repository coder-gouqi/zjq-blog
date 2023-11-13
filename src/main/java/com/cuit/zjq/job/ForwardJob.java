package com.cuit.zjq.job;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.mapper.EssayMapper;
import com.cuit.zjq.mapper.ForwardMapper;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.Forward;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 转发定时任务
 */
@Component
@EnableScheduling
public class ForwardJob {

    @Resource
    private EssayMapper essayMapper;

    @Resource
    private ForwardMapper forwardMapper;

    //每十分钟执行同步转发数
    @Scheduled(cron = "0 */10 * * * ?")
    public void synchronizeForward() {
        //查询所有文章
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayMapper.select(essayQueryRequest);
        //遍历所有id
        for (Essay essay : essayList) {
            String id = essay.getId();
            InteractionUpdateRequest interactionRequest = new InteractionUpdateRequest();
            interactionRequest.setEssayId(id);
            List<Forward> forwardList = forwardMapper.select(interactionRequest);
            int forwardCount = forwardList.size();
            Essay essayForUpdate = essayMapper.selectById(id);
            essayForUpdate.setForwardNum(forwardCount);
            int updateById = essayMapper.updateById(essayForUpdate);
            if (updateById > 0) {
                System.out.println("更新文章" + id + "转发数成功");
            }
        }
    }
}
