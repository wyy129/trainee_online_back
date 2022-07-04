package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.ProjectResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.trainee_online_back.entity.Vo.ProjectResultVo;

/**
* @author wangyangyang
* @description 针对表【project_result(毕设结果表)】的数据库操作Service
* @createDate 2022-06-08 10:43:31
*/
public interface ProjectResultService extends IService<ProjectResult> {
    /**
     * @description: 添加毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:25
     * @return: 添加的条数
     */
    int addProjectResult(ProjectResult projectResult);
    /**
     * @description: 更新毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:48
     * @return: 更新的条数
     */
    int updateProjectResult(ProjectResult projectResult);

    ProjectResultVo getProjectResult(String userId);
}
