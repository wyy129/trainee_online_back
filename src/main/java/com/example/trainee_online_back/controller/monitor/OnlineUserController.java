package com.example.trainee_online_back.controller.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.service.OnlineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 在线用户控制器
 * @author wangyangyang
 * @date: 2022/6/15 17:00
 * @return:
 */
@RestController
@RequestMapping("/monitor/onlineuser")
public class OnlineUserController {
    @Autowired
    private OnlineUserService onlineUserService;
    /**
     * @description: 分页获取所有在线用户
     * @author wangyangyang
     * @date: 2022/6/15 17:02
     * @return:
     */
    @RequestMapping("/getallonlineuser")
    public void getAllOnlineUser(BaseQueryDto baseQueryDto){
        onlineUserService.getAllOnlineUser(baseQueryDto);
    }
}
