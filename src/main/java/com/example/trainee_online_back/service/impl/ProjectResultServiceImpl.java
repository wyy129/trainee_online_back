package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.ProjectResult;
import com.example.trainee_online_back.entity.Vo.ProjectResultVo;
import com.example.trainee_online_back.mapper.ProjectInfoMapper;
import com.example.trainee_online_back.service.ProjectResultService;
import com.example.trainee_online_back.mapper.ProjectResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【project_result(毕设结果表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class ProjectResultServiceImpl extends ServiceImpl<ProjectResultMapper, ProjectResult>
        implements ProjectResultService {
    @Autowired
    private ProjectResultMapper projectResultMapper;

    /**
     * @description: 添加毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:27
     * @return: 成功添加的条数
     */
    @Override
    public int addProjectResult(ProjectResult projectResult) {
        return projectResultMapper.insert(projectResult);
    }

    /**
     * @description: 修改毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:51
     * @return: 修改的条数
     */
    @Override
    public int updateProjectResult(ProjectResult projectResult) {
        return projectResultMapper.updateById(projectResult);
    }

    @Override
    public ProjectResultVo getProjectResult(String userId) {
        return projectResultMapper.getProjectResult(userId);
    }
}




