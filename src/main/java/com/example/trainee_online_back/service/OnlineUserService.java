package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.Dto.BaseQueryDto;

import java.util.Collection;

/**
 * @author wangyangyang
 * @description: 在线用户接口
 * @date: 2022/6/15 17:03
 * @return:
 */
public interface OnlineUserService {
    Collection<String> getAllOnlineUser(BaseQueryDto baseQueryDto);

    /**
     * @description: 根据id强行退出某用户
     * @author wangyangyang
     * @date: 2022/6/16 8:17
     * @return: 是否成功
     */
    boolean loginOutOnlineUser(String userId);
}
