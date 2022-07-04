package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.SysLoginInfo;
import com.example.trainee_online_back.service.SysLoginInfoService;
import com.example.trainee_online_back.mapper.SysLoginInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【sys_login_info】的数据库操作Service实现
 * @createDate 2022-06-15 15:39:02
 */
@Service
public class SysLoginInfoServiceImpl extends ServiceImpl<SysLoginInfoMapper, SysLoginInfo>
        implements SysLoginInfoService {
    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;

    @Override
    public void addSysLoginInfo(SysLoginInfo sysLoginInfo) {
        sysLoginInfoMapper.insert(sysLoginInfo);
    }
}




