package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.ProjectInfo;
import com.example.trainee_online_back.service.ProjectInfoService;
import com.example.trainee_online_back.mapper.ProjectInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyangyang
* @description 针对表【project_info(毕业设计信息表)】的数据库操作Service实现
* @createDate 2022-06-08 10:43:31
*/
@Service
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfo>
    implements ProjectInfoService{

}




