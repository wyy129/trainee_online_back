package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.trainee_online_back.entity.Dto.LoginBodyDTO;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyangyang
 * @description: 用户登录控制器
 * @date: 2022/6/8 11:34
 */
@RestController
public class LoignController {
    @Autowired
    private UserService userService;

    /**
     * @description: 登录接口，获取token，并且把token放入缓存
     * @author wangyangyang
     * @date: 2022/6/8 12:53
     */
    @RequestMapping("/login")
    public JSONObject login(@RequestBody LoginBodyDTO loginBodyDTO) {
        String username = loginBodyDTO.getUsername();
        String password = loginBodyDTO.getPassword();
        String uuid = loginBodyDTO.getUuid();
        Assert.notEmpty(username, "用户名不能为空");
        Assert.notEmpty(password, "密码不能为空");
//        Assert.notEmpty(uuid,"uuid不能为空");
        String token = userService.login(username, password, uuid);
        if (StringUtils.isNotEmpty(token)) {
            User user = userService.getUserByUsername(username);
            JSONObject jsonuser = (JSONObject) JSONObject.toJSON(user);
            JSONObject obj = new JSONObject();
            obj.put("status", 0);
            obj.put("msg", "获取token成功");
            obj.put("token", token);
            obj.put("user", jsonuser);
            return obj;
        } else {
            return ResponseUtil.returnFail("获取token失败,请检查账号密码", token);
        }

    }
}
