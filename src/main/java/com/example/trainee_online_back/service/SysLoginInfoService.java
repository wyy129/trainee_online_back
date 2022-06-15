package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.SysLoginInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangyangyang
* @description 针对表【sys_login_info】的数据库操作Service
* @createDate 2022-06-15 15:39:02
*/
public interface SysLoginInfoService extends IService<SysLoginInfo> {

    void addSysLoginInfo(SysLoginInfo sysLoginInfo);
}
