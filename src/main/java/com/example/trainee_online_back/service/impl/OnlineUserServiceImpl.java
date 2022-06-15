package com.example.trainee_online_back.service.impl;

import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.service.OnlineUserService;
import com.example.trainee_online_back.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
}
