package com.example.trainee_online_back;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.utils.RedisCache;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class Test {
    @Autowired
    private UserMapper userMapper;

    @org.junit.jupiter.api.Test
    public void test() {

        String token = JWT.create().withAudience("1")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10000000))
                .sign(Algorithm.HMAC256("waimou" + "1"));
        System.out.println(token);
    }

    @org.junit.jupiter.api.Test
    public void test1() {
        RedisCache redisCache = new RedisCache();
        redisCache.setCacheObject("abc", "123");
    }

    @org.junit.jupiter.api.Test
    public void test2() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Autowired
    JavaMailSender javaMailSender;
    @org.junit.jupiter.api.Test
    void contextLoads() throws Exception {
        SimpleMailMessage message=new SimpleMailMessage();
        //发件人
        message.setFrom("waimouserver@foxmail.com");
        message.setText("内容");
        message.setSubject("主题");
        message.setTo("291882490@qq.com");
//        message.setCc("抄送人");
//        message.setBcc("密送人");
        javaMailSender.send(message);
    }

}
