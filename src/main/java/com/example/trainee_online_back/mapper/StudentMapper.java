package com.example.trainee_online_back.mapper;

import com.example.trainee_online_back.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wyy
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2022-05-10 18:46:29
* @Entity com.example.trainee_online_back.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




