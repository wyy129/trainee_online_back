package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: wyy
 * @date: 2022-06-07 20:10:45
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisCache redisCache;

    /**
     * @desc:
     * @author: wyy
     * @date: 2022-06-07 20:11:12
     **/
    @RequestMapping("/test1")
    public void test1() {
        redisCache.setCacheObject("abc","abc");
        Object abc = redisCache.getCacheObject("abc");
        System.out.println(abc);
    }
}
