package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Admin;
import com.example.trainee_online_back.service.AdminService;
import com.example.trainee_online_back.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author wyy
* @description 针对表【admin(管理员表)】的数据库操作Service实现
* @createDate 2022-05-10 18:46:29
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




