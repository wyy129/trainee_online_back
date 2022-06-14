package com.example.trainee_online_back.service.impl;

import com.example.trainee_online_back.entity.Vo.UserInfoVo;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息接口实现类
 * @author wangyangyang
 * @date: 2022/6/14 8:50
 * @return:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @description: 获取用户基础信息
     * @author wangyangyang
     * @date: 2022/6/14 8:57
     * @return:
     */
    @Override
    public UserInfoVo getUserInfo(String userid) {
        return userMapper.getUserInfo(userid);
    }
}
