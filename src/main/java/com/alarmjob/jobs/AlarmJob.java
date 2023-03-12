package com.alarmjob.jobs;

import com.alarmjob.service.CheckAlarm;
import com.alarmjob.service.impl.ChekAlarmImpl;
import com.alarmjob.service.impl.SendMailImpl;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * <p>Description: 监控报警任务</p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 19:09
 * @version 1.0.0
 *
 */
@Slf4j
public class AlarmJob implements Job {

    @Resource
    ChekAlarmImpl chekAlarm;
    @Resource
    SendMailImpl sendMail;

    /**
     * <p>Description: 监控任务处理</p>
     *
     * @author chenhan
     * @date 2023/3/11 19:13
     * @version 1.0.0
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        log.info("触发器：" + triggerKey.getName() + "，所属组：" + triggerKey.getGroup() + " 任务开始执行");
        if(chekAlarm.isAlarm()) {
            log.info("检测需要报警");
            log.info("发送报警邮件");
            if(sendMail.sendEmail()) {
                log.info("报警邮件发送成功");
            }else {
                log.info("报警邮件发送失败");
            }
        }
        log.info("触发器：" + triggerKey.getName() + "，所属组：" + triggerKey.getGroup() + " 任务执行完毕");
    }
}
