package com.example.trainee_online_back;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.trainee_online_back.utils.RedisCache;

import java.util.Date;

public class Test {
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
        redisCache.setCacheObject("abc","123");
    }

}
