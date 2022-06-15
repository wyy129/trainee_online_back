package com.example.trainee_online_back.controller.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.domain.Server;
import com.example.trainee_online_back.utils.ResponseUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 服务器监控
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController
{
    @GetMapping()
    public JSONObject getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return ResponseUtil.returnSuccess("服务器监控",server);
    }
}
