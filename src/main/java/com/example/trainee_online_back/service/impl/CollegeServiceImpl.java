package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.College;
import com.example.trainee_online_back.service.CollegeService;
import com.example.trainee_online_back.mapper.CollegeMapper;
import org.springframework.stereotype.Service;

/**
* @author wyy
* @description 针对表【college(学院表)】的数据库操作Service实现
* @createDate 2022-05-11 21:06:56
*/
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{

}




