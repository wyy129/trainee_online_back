package com.example.trainee_online_back.mapper;

import com.example.trainee_online_back.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wyy
* @description 针对表【admin(管理员表)】的数据库操作Mapper
* @createDate 2022-05-10 14:47:04
* @Entity com.example.trainee_online_back.entity.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




