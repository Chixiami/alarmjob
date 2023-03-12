package com.alarmjob.config;

import com.alarmjob.jobs.AlarmJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * <p>Description: 调度配置类</p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 19:51
 * @version 1.0.0
 *
 */
@Configuration
public class QuartzConfig {

    // 获取配置中的批处理定时任务时间
    @Value("${runtime}")
    private String runtime;

    // 定义Job示例
    @Bean
    public JobDetail jobDetail() {
        // JobBuilder：定义和创建JobDetail实例的接⼝
        return JobBuilder.newJob(AlarmJob.class).storeDurably().build();
    }

    // 触发Job执行
    @Bean
    public Trigger trigger() {
        // 创建Scheduler
        return TriggerBuilder.newTrigger()
                .withIdentity("监控报警任务", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule(runtime))
                .forJob(jobDetail())
                .build();
    }

}
