package com.alarmjob.service.impl;

import com.alarmjob.service.ReceiveMail;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/***
 * <p>Description: </p>
 *
 *
 * @return
 * @author chenhan
 * @date 2023/3/11 21:08
 * @version 1.0.0
 *
 */
@Service
@Slf4j
public class ReceiveMailImpl implements ReceiveMail {

    @Value("${spring.mail.scanMailUsername}")
    private String scanMailUsername;
    @Value("${spring.mail.scanMailPassword}")
    private String scanMailPassword;
    @Value("${spring.mail.scanMailHost}")
    private String scanMailHost;

    /**
     * <p>Description: 邮件接收</p>
     *
     * @author chenhan
     * @date 2023/3/12 19:21
     * @version 1.0.0
     */
    @Override
    public boolean receive() {
        Properties properties = new Properties();
        properties.put("mail.imap.host", scanMailHost);
        properties.put("mail.imap.auth.plain.disable", "true");
        Session mailsession = Session.getInstance(properties, null);
        mailsession.setDebug(false); //是否启用debug模式
        IMAPFolder folder= null;
        IMAPStore store=null;
        String logstr ="今日日志：";
        try{
            // 使用imap会话机制，连接服务器
            store=(IMAPStore)mailsession.getStore("imap");
            store.connect(scanMailHost, scanMailUsername, scanMailPassword);
            //收件箱
            folder=(IMAPFolder)store.getFolder("INBOX");
            // 使用只读方式打开收件箱
            folder.open(Folder.READ_ONLY);
            // 得到收件箱文件夹信息，获取邮件列表
            Message[] messages =folder.getMessages();
            // 解析所有邮件
            for (int i = 0, count = messages.length; i < count; i++) {
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                MimeMessage msg = (MimeMessage) messages[i];
                log.info(msg.getSubject());
            }

        }
        catch(Exception ex){
            System.err.println("不能以读写方式打开邮箱!");
            ex.printStackTrace();
        }finally {
            // 释放资源
            try{
                if(folder!=null)
                    folder.close(true); //退出收件箱时,删除做了删除标识的邮件
                if (store != null)
                    store.close();
            }catch(Exception bs){
                bs.printStackTrace();
            }
        }

        return false;
    }
}
