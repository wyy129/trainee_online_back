package com.example.trainee_online_back.mapper;

import com.example.trainee_online_back.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wyy
* @description 针对表【major(专业表)】的数据库操作Mapper
* @createDate 2022-05-11 21:06:56
* @Entity com.example.trainee_online_back.entity.Major
*/
@Mapper
public interface MajorMapper extends BaseMapper<Major> {

}




