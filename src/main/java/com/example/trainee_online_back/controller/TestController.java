package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.mapper.AdminUserMapper;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @Autowired
    private UserMapper userMapper;

    /**
     * @desc: 测试redis的使用
     * @author: wyy
     * @date: 2022-06-07 20:11:12
     **/
    @RequestMapping("/test1")
    public void test1() {
        redisCache.setCacheObject("abc", "abc");
        Object abc = redisCache.getCacheObject("abc");
        System.out.println(abc);
    }
/**
 * @description: 测试mybatis-plus
 * @author wangyangyang
 * @date: 2022/6/8 14:00
 */
    @RequestMapping("/test2")
    public void test2() {
        User user = new User();
        user.setUsername("a2bc");
        user.setPassword("1234");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
/**
 * @description: 测试接口拦截器，是否没错访问接口都更新redis缓存
 * @author wangyangyang
 * @date: 2022/6/8 14:01
 */
    @RequestMapping("/test3")
    public void test3() {
        System.out.println("进入到test3");
    }
}
