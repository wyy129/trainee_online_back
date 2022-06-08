package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Class;
import com.example.trainee_online_back.service.ClassService;
import com.example.trainee_online_back.mapper.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyangyang
* @description 针对表【class(班级表)】的数据库操作Service实现
* @createDate 2022-06-08 10:43:31
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{

}




