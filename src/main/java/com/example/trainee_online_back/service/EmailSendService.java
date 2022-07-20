package com.example.trainee_online_back.service;

/**
 * @desc: 邮件发送接口
 * @author: wangyangyang
 * @date: 2022-07-20 09:56:57
 * @return:
 **/
public interface EmailSendService {
    /**
     * @desc: 发送单独邮件
     * @author: wangyangyang
     * @date: 2022-07-20 10:06:21
     * @return:
     **/
    void sendEmail(String to, String subject, String text, String cc, String bcc);
}
