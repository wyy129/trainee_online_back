package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.Vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息接口
 * @author wangyangyang
 * @date: 2022/6/14 8:49
 * @return:
 */
public interface UserInfoService {
    /**
     * @description: 获取用户基础信息
     * @author wangyangyang
     * @date: 2022/6/14 8:51
     * @return:
     */
    UserInfoVo getUserInfo(String userid);
}
