package com.gxq.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by xuenianxiang on 2017/4/26.
 */

@Configuration
@EnableScheduling // 启用定时任务
public class OrderJob {


    @Scheduled(cron = "0 8 11 * * ?") // 每20秒执行一次
    public void scheduler() {
        System.out.println("每日定时执行任务");
    }
}
