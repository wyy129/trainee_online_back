package com.example.trainee_online_back.service.impl;

import com.example.trainee_online_back.constant.UserInfoConstants;
import com.example.trainee_online_back.entity.Vo.UserInfoVo;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.service.UserInfoService;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyangyang
 * @description: 用户信息接口实现类
 * @date: 2022/6/14 8:50
 * @return:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;

    /**
     * @description: 获取用户基础信息
     * @author wangyangyang
     * @date: 2022/6/14 8:57
     * @return:
     */
    @Override
    public UserInfoVo getUserInfo(String userid) {
        // 先去缓存查询用户信息，没有则去数据库中查询
        UserInfoVo cacheObject = redisCache.getCacheObject(UserInfoConstants.USERINFO + userid);
        if (cacheObject != null) {
            return cacheObject;
        } else {
            UserInfoVo userInfo = userMapper.getUserInfo(userid);
            // 放入缓存
            redisCache.setCacheObject(UserInfoConstants.USERINFO + userid, userInfo, 3, TimeUnit.DAYS);
            return userInfo;
        }
    }
}
