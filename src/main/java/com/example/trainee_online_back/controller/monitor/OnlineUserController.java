package com.example.trainee_online_back.controller.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.service.OnlineUserService;
import com.example.trainee_online_back.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author wangyangyang
 * @description: 在线用户控制器
 * @date: 2022/6/15 17:00
 * @return:
 */
@RestController
@RequestMapping("/monitor/onlineuser")
public class OnlineUserController {
    @Autowired
    private OnlineUserService onlineUserService;

    /**
     * @description: (分页)获取所有在线用户
     * @author wangyangyang
     * @date: 2022/6/15 17:02
     * @return:
     */
    @RequestMapping("/getallonlineuser")
    public JSONObject getAllOnlineUser(BaseQueryDto baseQueryDto) {
        Collection<String> allOnlineUser = onlineUserService.getAllOnlineUser(baseQueryDto);
        return ResponseUtil.returnSuccess("在线用户列表", allOnlineUser);
    }
}

