package com.example.trainee_online_back.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 用户表
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @ExcelProperty("用户id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     * 自动填充，从线程变量中获取用户id
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updatedBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.UPDATE)
    private Date updatedTime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色;0-学生，1-辅导员，3-老师
     */
    private Integer role;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学院id
     */
    private Integer collegeId;

    /**
     * 专业id
     */
    private String majorId;

    /**
     * 班级id
     */
    private String classId;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 逻辑删除;0为正常，-1为逻辑删除
     */
    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}