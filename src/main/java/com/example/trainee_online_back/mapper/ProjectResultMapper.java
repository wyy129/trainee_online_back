package com.example.trainee_online_back.mapper;

import com.example.trainee_online_back.entity.ProjectResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trainee_online_back.entity.Vo.ProjectResultVo;

/**
* @author wangyangyang
* @description 针对表【project_result(毕设结果表)】的数据库操作Mapper
* @createDate 2022-06-08 10:43:31
* @Entity com.example.trainee_online_back.entity.ProjectResult
*/
public interface ProjectResultMapper extends BaseMapper<ProjectResult> {

    ProjectResultVo getProjectResult(String userId);
}




