package com.example.trainee_online_back.entity.Vo;

import lombok.Data;

/**
 * @author wangyangyang
 * @description: 用于返回风险学生数据类
 * @date: 2022/6/9 12:48
 */
@Data
public class RiskStudent {
    String temperature_id;
    String temperature_value;
    String temperature_address;
    String temperature_symptom;
    String temperature_creadeTime;
    String userid;
    String name;
    String phone;
}
