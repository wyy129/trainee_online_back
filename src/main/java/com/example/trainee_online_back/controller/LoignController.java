package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.trainee_online_back.entity.Dto.LoginBodyDTO;
import com.example.trainee_online_back.entity.SysLoginInfo;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.SysLoginInfoService;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.utils.DateUtils;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import com.example.trainee_online_back.utils.ip.AddressUtils;
import com.example.trainee_online_back.utils.ip.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wangyangyang
 * @description: 用户登录控制器
 * @date: 2022/6/8 11:34
 */
@RestController
public class LoignController {
    @Autowired
    private UserService userService;
    @Autowired
    private SysLoginInfoService sysLoginInfoService;

    /**
     * @description: 登录接口，获取token，并且把token放入缓存
     * @author wangyangyang
     * @date: 2022/6/8 12:53
     */
    @RequestMapping("/login")
    public JSONObject login(@RequestBody LoginBodyDTO loginBodyDTO, HttpServletRequest httpServletRequest) {
        String username = loginBodyDTO.getUsername();
        String password = loginBodyDTO.getPassword();
        String uuid = loginBodyDTO.getUuid();
        Assert.notEmpty(username, "用户名不能为空");
        Assert.notEmpty(password, "密码不能为空");
        String ipAddr = IpUtils.getIpAddr(httpServletRequest);
        String address = AddressUtils.getRealAddressByIP(ipAddr);
        SysLoginInfo sysLoginInfo = new SysLoginInfo();
        sysLoginInfo.setUsername(username);
        sysLoginInfo.setIpAddress(ipAddr);
        sysLoginInfo.setAddress(address);
        if (StringUtils.isNotEmpty(loginBodyDTO.getAddress())) {
            sysLoginInfo.setAddress(loginBodyDTO.getAddress());
        }
        sysLoginInfo.setLoginDate(DateUtils.getNowDate());
//        Assert.notEmpty(uuid,"uuid不能为空");
        JSONObject token = userService.login(username, password, uuid);
        if (token != null) {
            sysLoginInfo.setSuccess("0");
            sysLoginInfoService.addSysLoginInfo(sysLoginInfo);
            return token;
        } else {
            sysLoginInfo.setSuccess("1");
            sysLoginInfoService.addSysLoginInfo(sysLoginInfo);
            return ResponseUtil.returnFail("获取token失败,请检查账号密码", token);
        }

    }

    /**
     * @desc: 用户登出功能
     * @author: wyy
     * @date: 2022-06-26 17:57:07
     * @return: 是否登出成功
     **/
    @RequestMapping("/logout")
    public JSONObject logOut() {
        boolean b = userService.logOut();
        if (b) {
            return ResponseUtil.returnSuccess("登出成功", b);
        }
        return ResponseUtil.returnFail("登出失败", b);
    }
}
