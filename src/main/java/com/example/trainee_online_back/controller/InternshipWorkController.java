package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.InternshipWork;
import com.example.trainee_online_back.exception.BasicInfoException;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.InternshipWorkService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/addinternshipwork")
    public JSONObject addInternshipWork(@RequestBody InternshipWork internshipWork) {
        System.out.println(internshipWork);
        String workTitle = internshipWork.getWorkTitle();
        String workContent = internshipWork.getWorkContent();
        Integer userId = internshipWork.getUserId();
        if (StringUtils.isEmpty(workContent) || StringUtils.isEmpty(workTitle) || "".equals(userId)) {
            throw new ParameterException("参数不能未空");
        }
        int i = internshipWorkService.addInternship(internshipWork);
        if (i == 1) {
            return ResponseUtil.returnSuccess("成功添加1条数据", i);
        }
        return ResponseUtil.returnFail("添加失败", i);
    }

}
