package com.cuit.zjq.job;

import com.cuit.zjq.common.InteractionUpdateRequest;
import com.cuit.zjq.mapper.EssayMapper;
import com.cuit.zjq.mapper.FavourMapper;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.domain.Favour;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏定时任务
 */
@Component
@EnableScheduling
public class FavourJob {

    @Resource
    private EssayMapper essayMapper;

    @Resource
    private FavourMapper favourMapper;

    //每十分钟执行同步收藏数
    @Scheduled(cron = "0 */10 * * * ?")
    public void synchronizeFavour() {
        //查询所有文章
        EssayQueryRequest essayQueryRequest = new EssayQueryRequest();
        List<Essay> essayList = essayMapper.select(essayQueryRequest);
        //遍历所有id
        for (Essay essay : essayList) {
            String id = essay.getId();
            InteractionUpdateRequest interactionRequest = new InteractionUpdateRequest();
            interactionRequest.setEssayId(id);
            List<Favour> favourList = favourMapper.select(interactionRequest);
            int favourCount = favourList.size();
            Essay essayForUpdate = essayMapper.selectById(id);
            essayForUpdate.setFavourNum(favourCount);
            int updateById = essayMapper.updateById(essayForUpdate);
            if (updateById > 0) {
                System.out.println("更新文章" + id + "收藏数成功");
            }
        }
    }
}
