package com.example.trainee_online_back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Dto.GetProjectDTO;
import com.example.trainee_online_back.entity.ProjectInfo;
import com.example.trainee_online_back.service.ProjectInfoService;
import com.example.trainee_online_back.mapper.ProjectInfoMapper;
import com.example.trainee_online_back.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    /**
     * @description: 添加毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 10:11
     * @return: 添加的条数
     */
    @Override
    public int addProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.insert(projectInfo);
    }

    /**
     * @description: 根据毕设信息id删除毕设
     * @author wangyangyang
     * @date: 2022/6/13 10:12
     * @return: 删除的条数
     */
    @Override
    public int deleteProjectInfoById(Integer project_info_id) {
        return projectInfoMapper.deleteById(project_info_id);
    }

    /**
     * @description: 更新毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 10:13
     * @return: 更新的条数
     */
    @Override
    public int updateProjectInfo(ProjectInfo projectInfo) {
        Integer projectId = projectInfo.getProjectId();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("project_id", projectId);
        return projectInfoMapper.update(projectInfo, queryWrapper);
    }

    /**
     * @description: 根据专业id，分页获取毕设信息（添加用户id，目的是 老师可以获取自己发布的毕设）
     * @author wangyangyang
     * @date: 2022/6/13 9:24
     * @return:
     */
    @Override
    public JSONObject getProject(GetProjectDTO getProjectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer majorId = getProjectDTO.getMajorId();
        Integer userId = getProjectDTO.getUserId();
        queryWrapper.eq((majorId != null), "major_id", majorId);
        queryWrapper.eq((userId != null), "user_id", userId);
        Page page = new Page(Optional.ofNullable(getProjectDTO.getPage()).orElse(1L), Optional.ofNullable(getProjectDTO.getPageSize()).orElse(20L));
        return PageUtil.getPageData(projectInfoMapper.selectPage(page, queryWrapper));
    }
}




