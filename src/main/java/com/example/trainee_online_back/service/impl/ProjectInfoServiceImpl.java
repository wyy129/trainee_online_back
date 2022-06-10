package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.ProjectInfo;
import com.example.trainee_online_back.service.ProjectInfoService;
import com.example.trainee_online_back.mapper.ProjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【project_info(毕业设计信息表)】的数据库操作Service实现
 * @createDate 2022-06-10 16:26:13
 */
@Service
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfo>
        implements ProjectInfoService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public int addProjectInfo(ProjectInfo projectInfo) {
        int insert = projectInfoMapper.insert(projectInfo);
        return insert;
    }

    @Override
    public int deleteProjectInfoById(Integer project_info_id) {
        int delete = projectInfoMapper.deleteById(project_info_id);
        return delete;
    }

    @Override
    public int updateProjectInfo(ProjectInfo projectInfo) {
        int update = projectInfoMapper.updateById(projectInfo);
        return update;
    }

    @Override
    public void getProject() {
    }
}




