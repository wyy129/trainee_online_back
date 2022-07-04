package com.example.trainee_online_back.service;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.Dto.GetProjectDTO;
import com.example.trainee_online_back.entity.ProjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wangyangyang
 * @description 针对表【project_info(毕业设计信息表)】的数据库操作Service
 * @createDate 2022-06-10 16:26:13
 */
public interface ProjectInfoService extends IService<ProjectInfo> {
    /**
     * @description: 添加毕业设计信息
     * @author wangyangyang
     * @date: 2022/6/10 16:28
     * @return: 成功添加的条数
     */
    int addProjectInfo(ProjectInfo projectInfo);

    /**
     * @description: 根据id删除毕设信息
     * @author wangyangyang
     * @date: 2022/6/10 16:36
     * @return: 删除的条数
     */
    int deleteProjectInfoById(Integer id);

    /**
     * @description: 根据传过来的毕设信息，进行毕设信息更新
     * @author wangyangyang
     * @date: 2022/6/10 16:41
     * @return: 更新的条数
     */
    int updateProjectInfo(ProjectInfo projectInfo);

    /**
     * @description: 根据专业id，分页获取毕设信息（可以添加用户id，目的是 老师可以获取自己发布的毕设）
     * @author wangyangyang
     * @date: 2022/6/10 16:46
     * @return: 列表集合
     */
    JSONObject getProject(GetProjectDTO getProjectDTO);
}
