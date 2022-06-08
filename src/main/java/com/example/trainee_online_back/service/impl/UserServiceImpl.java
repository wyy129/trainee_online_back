package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.utils.RedisCache;
import com.example.trainee_online_back.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyangyang
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(String username, String password, String uuid) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        userQueryWrapper.eq("password", password);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            return "";
        }
        String userid = user.getId().toString();
        String token = TokenUtil.createToken(userid);
        redisCache.setCacheObject("user_" + userid + "token", token, 20, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        return userMapper.selectOne(userQueryWrapper);

    }
}




