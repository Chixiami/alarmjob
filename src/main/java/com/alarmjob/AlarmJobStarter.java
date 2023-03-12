package com.alarmjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * <p>Description: 启动入口</p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 19:15
 * @version 1.0.0
 *
 */
@SpringBootApplication
@Slf4j
public class AlarmJobStarter {

    public static void main(String[] args) {
        SpringApplication.run(AlarmJobStarter.class);
    }
}
