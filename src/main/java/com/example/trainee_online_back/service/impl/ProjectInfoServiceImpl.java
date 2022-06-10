package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Dto.GetProjectDTO;
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
        return projectInfoMapper.insert(projectInfo);
    }

    @Override
    public int deleteProjectInfoById(Integer project_info_id) {
        return projectInfoMapper.deleteById(project_info_id);
    }

    @Override
    public int updateProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.updateById(projectInfo);
    }

    /**
     * @desc: 未完成！！！！！！！
     * @author: wyy
     * @date: 2022-06-10 21:00:50
     * @return:
     **/
    @Override
    public Page<ProjectInfo> getProject(GetProjectDTO getProjectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("major_id", getProjectDTO.getMajorId());
        Page<ProjectInfo> projectInfoPage = new Page<>();
        return projectInfoMapper.selectPage(projectInfoPage, queryWrapper);
    }
}




