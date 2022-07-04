package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangyangyang
* @description 针对表【admin_user(管理员表)】的数据库操作Service
* @createDate 2022-06-08 10:43:31
*/
public interface AdminUserService extends IService<AdminUser> {
    /**
     * @description: 管理员登录
     * @author wangyangyang
     * @date: 2022/6/21 16:59
     * @return: 管理员对象
     */
    AdminUser adminLogin(String adminUsername, String adminPassword);
}
