package com.cuit.zjq.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 点赞定时任务
 */
@Component
@EnableScheduling
public class ThumbJob {
    //每十分钟执行同步点赞数
    @Scheduled(cron = "0 */10 * * * ?")
    public void synchronizeThumb() {

    }
}
