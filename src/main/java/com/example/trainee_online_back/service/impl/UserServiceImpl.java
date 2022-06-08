package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyangyang
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-06-08 10:43:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




