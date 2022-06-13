package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.InternshipWork;
import com.example.trainee_online_back.exception.BasicInfoException;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.InternshipWorkService;
import com.example.trainee_online_back.utils.RequestUtil;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangyangyang
 * @description: 周记控制器
 * @date: 2022/6/13 12:42
 * @return:
 */
@RestController
@RequestMapping("/internshipwork")
public class InternshipWorkController {
    @Autowired
    private InternshipWorkService internshipWorkService;

    /**
     * @description: 添加周记
     * @author wangyangyang
     * @date: 2022/6/13 14:50
     * @return: 返回条数
     */
    @RequestMapping("/addinternshipwork")
    public JSONObject addInternshipWork(@RequestBody InternshipWork internshipWork) {
        System.out.println(internshipWork);
        String workTitle = internshipWork.getWorkTitle();
        String workContent = internshipWork.getWorkContent();
        Integer userId = internshipWork.getUserId();
        if (StringUtils.isEmpty(workContent) || StringUtils.isEmpty(workTitle) || "".equals(userId)) {
            throw new ParameterException("参数不能未空");
        }
        if (!RequestUtil.getTLUserId().toString().equals(userId.toString())) {
            throw new ParameterException("操作用户和被修改信息用户不相同");
        }
        int i = internshipWorkService.addInternship(internshipWork);
        if (i == 1) {
            return ResponseUtil.returnSuccess("成功添加1条数据", i);
        }
        return ResponseUtil.returnFail("添加失败", i);
    }

    /**
     * @description: 根据周记id删除周记（有个坑，只要是登录用户就可以伪造删除任意周记。解决方法：先根据周记id查询出来属于用户的id，和线程用户id进行匹配）
     * @author wangyangyang
     * @date: 2022/6/13 15:00
     * @return: 删除条数
     */
    @RequestMapping("/deleteinternshipworkbyid")
    public JSONObject deleteInternshipWorkById(@RequestBody Map map) {
        Integer internshipworkId = Integer.valueOf(map.get("internshipworkId").toString());
        if ("".equals(internshipworkId)) {
            throw new ParameterException("删除id不能为空");
        }
        int i = internshipWorkService.deleteInternshipById(internshipworkId);
        if (i != 1) {
            return ResponseUtil.returnFail("删除错误", i);
        }
        return ResponseUtil.returnSuccess("删除成功", i);
    }

}
