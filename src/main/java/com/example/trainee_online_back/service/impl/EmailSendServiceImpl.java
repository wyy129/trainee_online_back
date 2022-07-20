package com.example.trainee_online_back.service.impl;

import com.example.trainee_online_back.service.EmailSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @desc: 发送邮件实现接口
 * @author: wangyangyang
 * @date: 2022-07-20 10:01:23
 * @return:
 **/
@Service
public class EmailSendServiceImpl implements EmailSendService {
    @Value("spring.mail.username")
    private String form;

    @Override
    public void sendEmail(String to, String subject, String text, String cc, String bcc) {
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom(form);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
    }
}
