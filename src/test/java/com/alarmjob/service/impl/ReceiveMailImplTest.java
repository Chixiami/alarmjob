package com.alarmjob.service.impl;

import com.alarmjob.AlarmJobStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiveMailImplTest {
    @Resource
    ReceiveMailImpl receiveMail;

    @Test
    public void test1() {
        receiveMail.receive();
    }

}