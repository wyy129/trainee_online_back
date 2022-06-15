package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.ProjectResult;
import com.example.trainee_online_back.entity.Vo.ProjectResultVo;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.ProjectResultService;
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
 * @description: 毕设结果控制器
 * @date: 2022/6/15 10:03
 * @return:
 */
@RestController
@RequestMapping("/projectresult")
public class ProjectResultController {
    @Autowired
    private ProjectResultService projectResultService;

    /**
     * @description: 增加毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:09
     * @return: 增加的条数
     */
    @RequestMapping("/addprojectresult")
    public JSONObject addProjectResult(@RequestBody ProjectResult projectResult) {

        Integer userId = projectResult.getUserId();
        Integer projectInfoId = projectResult.getProjectInfoId();
        if (StringUtils.isEmpty(String.valueOf(userId)) || StringUtils.isEmpty(String.valueOf(projectInfoId))) {
            throw new ParameterException("参数有误");
        }
        VerifyUserUtil.verifyOperationUser(String.valueOf(userId));
        ProjectResultVo result = projectResultService.getProjectResult(projectResult.getUserId().toString());
        if (result != null){
            throw new ParameterException("已经存在毕设信息，不允许新增");
        }
        int i = projectResultService.addProjectResult(projectResult);
        return ResponseUtil.returnSuccess("成功添加i条数据", i);
    }

    /**
     * @description: 更新毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:09
     * @return: 更新的条数
     */
    @RequestMapping("/updateprojectresult")
    public JSONObject updateProjectResult(@RequestBody ProjectResult projectResult) {

        Integer userId = projectResult.getUserId();
        Integer projectInfoId = projectResult.getProjectInfoId();
        if (StringUtils.isEmpty(String.valueOf(userId)) || StringUtils.isEmpty(String.valueOf(projectInfoId))) {
            throw new ParameterException("参数有误");
        }
        // 有坑，即登录用户可以随意伪造数据进行数据更新，比如登录用户，可以修改成绩！！！------待解决

        int i = projectResultService.updateProjectResult(projectResult);
        return ResponseUtil.returnSuccess("成功更新i条数据", i);
    }

    /**
     * @description: 根据用户id获取毕设结果信息
     * @author wangyangyang
     * @date: 2022/6/15 10:53
     * @return: 毕设结果信息VO
     */
    @RequestMapping("/getprojectresultbyuserid")
    public JSONObject getProjectResultByUserId(@RequestBody Map map) {
        String userId = map.get("userId").toString();
        if (StringUtils.isEmpty(userId)) {
            throw new ParameterException("参数有误");
        }
        // 有坑，即登录用户可以随意伪造数据进行数据更新，------待解决

        ProjectResultVo resultVo = projectResultService.getProjectResult(userId);
        return ResponseUtil.returnSuccess("成功获取i条数据", resultVo);
    }


}
