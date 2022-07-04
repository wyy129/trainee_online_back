package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.AdminUser;
import com.example.trainee_online_back.service.AdminUserService;
import com.example.trainee_online_back.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【admin_user(管理员表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser>
        implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * @description: 管理员登录
     * @author wangyangyang
     * @date: 2022/6/21 17:00
     * @return: 管理员对象
     */
    @Override
    public AdminUser adminLogin(String adminUsername, String adminPassword) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("admin_username", adminUsername);
        queryWrapper.eq("admin_password", adminPassword);
        return adminUserMapper.selectOne(queryWrapper);
    }
}




