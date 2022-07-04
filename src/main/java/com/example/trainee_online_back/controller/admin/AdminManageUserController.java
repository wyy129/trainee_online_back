package com.example.trainee_online_back.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyangyang
 * @description: 管理员管理用户
 * @date: 2022/6/28 10:27
 * @return:
 */
@RestController
@RequestMapping("/adminmanageuser")
public class AdminManageUserController {
    @Autowired
    private UserService userService;

    /**
     * @description: 添加用户
     * @author wangyangyang
     * @date: 2022/6/28 10:36
     * @return: 添加的条数
     */
    @RequestMapping("/adduser")
    public JSONObject addUser(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            ResponseUtil.returnFail("用户信息不能为空", user);
        }
        User u = userService.getUserByUsername(user.getUsername());
        Assert.notNull(u, "用户名已存在");
        int i = userService.addUser(user);
        return ResponseUtil.returnSuccess("成功添加i条数据", i);
    }

}
