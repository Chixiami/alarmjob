package com.alarmjob.service;

/**
 * <p>Description: 校验是否需要报警</p>
 *
 * @author chenhan
 * @date 2023/3/11 22:04
 * @version 1.0.0
 */
public interface CheckAlarm {
    /**
     * <p>Description: 业务校验 true-需要报警 false-不需要报警</p>
     *
     * @author chenhan
     * @date 2023/3/11 22:05
     * @version 1.0.0
     */
    boolean isAlarm();
}
