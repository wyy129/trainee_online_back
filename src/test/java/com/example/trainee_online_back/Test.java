package com.example.trainee_online_back;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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

}
