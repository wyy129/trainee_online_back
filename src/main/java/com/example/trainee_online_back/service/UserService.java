package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.Dto.LoginBodyDTO;
import com.example.trainee_online_back.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wangyangyang
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2022-06-08 10:43:31
 */
public interface UserService extends IService<User> {

    /**
     * @description: 根据账号密码去获取token
     * @author wangyangyang
     * @date: 2022/6/8 13:09
     */
    String login(String username, String password, String uuid);

    /**
     * @description: 根据用户id获取用户信息
     * @author wangyangyang
     * @date: 2022/6/8 13:10
     */
    User getUserByUsername(String username);
}
