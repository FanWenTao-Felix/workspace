package org.springbootdev.core.boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ScheduleConfig
 * useage:@Scheduled(cron = "0 30 12 * * ?")
 * @author XiongNeng
 * @version 1.0
 * @since 2017/9/13
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(scheduleTaskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public ExecutorService scheduleTaskExecutor() {
        return Executors.newScheduledThreadPool(5);
    }
}
