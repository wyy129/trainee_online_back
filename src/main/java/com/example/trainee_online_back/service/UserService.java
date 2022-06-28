package com.example.trainee_online_back.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
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

    /**
     * @description: 分页获取所有学生信息
     * @author wangyangyang
     * @date: 2022/6/9 11:22
     */
    Page<User> getAllStudent(BaseQueryDto baseQueryDto);

    /**
     * @desc: 用户登出
     * @author: wyy
     * @date: 2022-06-27 21:18:29
     * @return: 是否成功
     **/
    boolean logOut();

    /**
     * @desc: 添加用户
     * @author: wyy
     * @date: 2022-06-27 21:17:23
     * @return: 添加条数
     **/
    int addUser(User user);

    /**
     * @desc: 根据用户id删除用户
     * @author: wyy
     * @date: 2022-06-27 21:55:26
     * @return: 删除的数量
     **/
    int deleteUserById(Long userId);
}
