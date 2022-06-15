package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import org.springframework.stereotype.Service;

/**
 * @description: 在线用户接口
 * @author wangyangyang
 * @date: 2022/6/15 17:03
 * @return:
 */
public interface OnlineUserService {
    void getAllOnlineUser(BaseQueryDto baseQueryDto);
}
