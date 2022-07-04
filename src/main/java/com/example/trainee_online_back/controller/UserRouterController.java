//package com.example.trainee_online_back.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.toolkit.Assert;
//import com.example.trainee_online_back.service.UserRouterService;
//import com.example.trainee_online_back.utils.ResponseUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author wangyangyang
// * @description: 用户路由控制器
// * @date: 2022/6/9 10:52
// */
//@RestController
//@RequestMapping("/userrouter")
//public class UserRouterController {
//    @Autowired
//    private UserRouterService userRouterService;
//
//    /**
//     * @description: 用户根据角色获取路由
//     * @author wangyangyang
//     * @date: 2022/6/9 10:54
//     */
//    @RequestMapping("/getrouter")
//    public JSONObject gerRouter(@RequestBody JSONObject jsonObject) {
//        Integer role = (Integer) jsonObject.get("role");
//        JSONObject router = userRouterService.getRouter(role);
//        Assert.notNull(router, "未获取到路由");
//        return ResponseUtil.returnSuccess("获取路由成功", router);
//    }
//}
