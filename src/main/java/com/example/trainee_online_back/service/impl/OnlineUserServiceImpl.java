package com.example.trainee_online_back.service.impl;

import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.service.OnlineUserService;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author wangyangyang
 * @description: 在线用户监控服务实现类
 * @date: 2022/6/16 8:19
 * @return:
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService {
    @Autowired
    private RedisCache redisCache;

    @Override
    public Collection<String> getAllOnlineUser(BaseQueryDto baseQueryDto) {
        Collection<String> keys = redisCache.keys("user" + "*");
//        List<User> subList = list.stream().skip((pageNo-1)*pageSize).limit(pageSize).
//                collect(Collectors.toList());
        System.out.println(keys);
        return keys;
    }

    /**
     * @description: 根据id强行退出某用户
     * @author wangyangyang
     * @date: 2022/6/16 8:17
     * @return: 是否成功
     */
    @Override
    public boolean loginOutOnlineUser(String userId) {
        return redisCache.deleteObject("user_" + userId + "token");
    }
}
