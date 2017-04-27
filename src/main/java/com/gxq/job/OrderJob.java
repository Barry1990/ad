package com.gxq.job;

import com.gxq.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by xuenianxiang on 2017/4/26.
 */

@Configuration
@EnableScheduling // 启用定时任务
public class OrderJob {

    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点结算
    public void scheduler() {

        int result = orderService.insertOrderStatus();

        logger.info("后台作业------插入"+result+"条交易记录");

    }
}
