package com.example.trainee_online_back.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @desc: 根据班级id获取学生列表
     * @author: wangyangyang
     * @date: 2022-07-20 15:38:41
     * @return: 学生列表
     **/
    List<User> selectAllByClassId(@Param("classId") String classId);


}




