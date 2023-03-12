package com.alarmjob.service.impl;

import com.alarmjob.service.CheckAlarm;
import org.springframework.stereotype.Service;

/***
 * <p>Description: </p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 22:05
 * @version 1.0.0
 *
 */
@Service
public class ChekAlarmImpl implements CheckAlarm {
    /**
     * <p>Description: 业务校验 true-需要报警 false-不需要报警</p>
     *
     * @author chenhan
     * @date 2023/3/11 22:05
     * @version 1.0.0
     */
    @Override
    public boolean isAlarm() {
        // 此处写校验逻辑
        return false;
    }
}
