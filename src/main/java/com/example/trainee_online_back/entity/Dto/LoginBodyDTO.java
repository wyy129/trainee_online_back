package com.example.trainee_online_back.entity.Dto;

import lombok.Data;

/**
 * @author wangyangyang
 * @description: 登录信息
 * @date: 2022/6/8 11:44
 */
@Data
public class LoginBodyDTO {
    /**
     * @description: 用户名
     * @author wangyangyang
     * @date: 2022/6/8 11:48
     */
    private String username;
    /**
     * @description: 密码
     * @author wangyangyang
     * @date: 2022/6/8 11:48
     */
    private String password;
    /**
     * @description: uuid
     * @author wangyangyang
     * @date: 2022/6/8 11:48
     */
    private String uuid;
}
