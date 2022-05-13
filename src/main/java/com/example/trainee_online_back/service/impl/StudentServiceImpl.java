package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Student;
import com.example.trainee_online_back.service.StudentService;
import com.example.trainee_online_back.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author wyy
* @description 针对表【student(学生表)】的数据库操作Service实现
* @createDate 2022-05-12 11:59:16
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




