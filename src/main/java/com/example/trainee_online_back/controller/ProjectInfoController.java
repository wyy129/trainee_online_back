package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.annotation.Role;
import com.example.trainee_online_back.entity.Dto.GetProjectDTO;
import com.example.trainee_online_back.entity.ProjectInfo;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.ProjectInfoService;
import com.example.trainee_online_back.utils.RequestUtil;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import com.example.trainee_online_back.utils.VerifyUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangyangyang
 * @description: 毕设信息控制器
 * @date: 2022/6/13 16:28
 * @return:
 */
@RestController
@RequestMapping("/projectinfo")
public class ProjectInfoController {
    @Autowired
    private ProjectInfoService projectInfoService;

    /**
     * @description: 添加毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 16:41
     * @return: 添加成功的条数
     * role:教师
     */
    @Role("3")
    @RequestMapping("/addprojectinfo")
    public JSONObject addProjectInfo(@RequestBody ProjectInfo projectInfo) {
        String projectName = projectInfo.getProjectName();
        String projectContent = projectInfo.getProjectContent();
        String majorId = projectInfo.getMajorId().toString();
        String userId = projectInfo.getUserId().toString();
        if (StringUtils.isEmpty(projectContent) || StringUtils.isEmpty(projectName) || StringUtils.isEmpty(majorId) || StringUtils.isEmpty(userId)) {
            throw new ParameterException("参数不能为空");

        }
        VerifyUserUtil.verifyOperationUser(userId);
        int i = projectInfoService.addProjectInfo(projectInfo);
        return ResponseUtil.returnSuccess("成功添加1条", i);
    }

    /**
     * @description: 根据毕设信息id删除毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 17:09
     * @return: 删除的条数
     * role：教师
     */
    @RequestMapping("/deleteprojectinfobyid")
    public JSONObject deleteProjectInfoById(@RequestBody Map map) {
        String projectInfoId = map.get("projectInfoId").toString();
        String userid = map.get("userid").toString();
        if (StringUtils.isEmpty(projectInfoId) || StringUtils.isEmpty(userid)) {
            throw new ParameterException("参数不能为空");
        }
        VerifyUserUtil.verifyOperationUser(userid);
        int i = projectInfoService.deleteProjectInfoById(Integer.valueOf(projectInfoId));
        return ResponseUtil.returnSuccess("删除i条", i);
    }

    /**
     * @description: 根据毕设信息id更新毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 17:20
     * @return: 更新的条数
     * role：教师
     */
    @Role("3")
    @RequestMapping("/updateprojectinfo")
    public JSONObject updateProjectInfo(@RequestBody ProjectInfo projectInfo) {
        String projectId = projectInfo.getProjectId().toString();
        String userId = projectInfo.getUserId().toString();
        if (StringUtils.isEmpty(projectId) || StringUtils.isEmpty(userId)) {
            throw new ParameterException("参数不能为空");
        }
        VerifyUserUtil.verifyOperationUser(userId);
        int i = projectInfoService.updateProjectInfo(projectInfo);
        return ResponseUtil.returnSuccess("更新成功i条", i);
    }

    /**
     * @description: 根据条件分页获取毕设信息
     * @author wangyangyang
     * @date: 2022/6/13 17:22
     * @return: 毕设信息列表
     */
    @RequestMapping("/getProject")
    public JSONObject getProject(@RequestBody GetProjectDTO getProjectDTO) {
        JSONObject projectList = projectInfoService.getProject(getProjectDTO);
        return ResponseUtil.returnSuccess("毕设信息列表", projectList);
    }

}
