package com.example.trainee_online_back.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author wangyangyang
 * @description: 用于返回用户信息实体类
 * @date: 2022/6/14 9:32
 * @return:
 */
@Data
public class UserInfoVo {
    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 角色id
     */
    private String role;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 学院id
     */
    private Integer collegeId;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 学院简介
     */
    private String collegeExplan;
    /**
     * 专业id
     */
    private Integer majorId;
    /**
     * 专业名称
     */
    private String majorName;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 班级描述
     */
    private String classDec;


}
