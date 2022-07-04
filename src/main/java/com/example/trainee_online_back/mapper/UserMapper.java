package com.example.trainee_online_back.mapper;

import com.example.trainee_online_back.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trainee_online_back.entity.Vo.UserInfoVo;

/**
 * @author wangyangyang
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2022-06-08 10:43:31
 * @Entity com.example.trainee_online_back.entity.User
 */
public interface UserMapper extends BaseMapper<User> {

    UserInfoVo getUserInfo(String userid);
}




