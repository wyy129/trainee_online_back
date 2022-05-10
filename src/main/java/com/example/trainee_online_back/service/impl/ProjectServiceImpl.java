package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Project;
import com.example.trainee_online_back.service.ProjectService;
import com.example.trainee_online_back.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

/**
* @author wyy
* @description 针对表【project(毕业设计表)】的数据库操作Service实现
* @createDate 2022-05-10 14:47:05
*/
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project>
    implements ProjectService{

}




