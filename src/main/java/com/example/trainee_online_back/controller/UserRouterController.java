package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.trainee_online_back.service.UserRouterService;
import com.example.trainee_online_back.utils.RedisCache;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyangyang
 * @description: 用户路由控制器
 * @date: 2022/6/9 10:52
 */
@RestController
@RequestMapping("/userrouter")
public class UserRouterController {
    private static final String ROUTER = "router-";
    @Autowired
    private RedisCache redisCache;

    @GetMapping("/getrouterbyrole")
    public JSONObject getRouterByRole(String role) {
        Object cacheObject = redisCache.getCacheObject(ROUTER + role);
        if (cacheObject == null) {
            return ResponseUtil.returnFail("路由信息为空", null);
        }
        return ResponseUtil.returnSuccess("路由信息是", cacheObject);
    }
}
