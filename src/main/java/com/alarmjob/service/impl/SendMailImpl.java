package com.alarmjob.service.impl;

import com.alarmjob.service.SendMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * <p>Description: 发送邮件实现类</p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 20:43
 * @version 1.0.0
 *
 */
@Service
@Slf4j
public class SendMailImpl implements SendMail {

    @Resource
    JavaMailSender javaMailSender;

    @Value("${spring.mail.subject}")
    private String subject;
    @Value("${spring.mail.username}")
    private String fromEmailAddress;
    @Value("${spring.mail.toEmailAddress}")
    private String toEmailAddress;
    @Value("${spring.mail.emailContext}")
    private String emailContext;

    /**
     * <p>Description: 邮件发送</p>
     *
     * @author chenhan
     * @date 2023/3/11 21:26
     * @version 1.0.0
     */
    @Override
    public boolean sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmailAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(emailContext);
        simpleMailMessage.setFrom(fromEmailAddress);
        javaMailSender.send(simpleMailMessage);
        return true;
    }
}
