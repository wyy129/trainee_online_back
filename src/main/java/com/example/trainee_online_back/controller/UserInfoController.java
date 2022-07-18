package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.trainee_online_back.annotation.Log;
import com.example.trainee_online_back.entity.Vo.UserInfoVo;
import com.example.trainee_online_back.service.UserInfoService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.VerifyUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangyangyang
 * @description: 用户信息控制器
 * @date: 2022/6/14 8:43
 * @return:
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * @description: 获取用户基础信息
     * @author wangyangyang
     * @date: 2022/6/14 8:47
     * @return: 用户基础信息
     */
    @RequestMapping("/getuserinfo")
    @Log(title = "获取用户基础信息")
    public JSONObject getUserInfo(@RequestBody Map map) {
        String userid = map.get("userid").toString();
        VerifyUserUtil.verifyOperationUser(userid);
        UserInfoVo userInfo = userInfoService.getUserInfo(userid);
        return ResponseUtil.returnSuccess("用户基础信息", userInfo);

    }
}
