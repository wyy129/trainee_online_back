package com.example.trainee_online_back.entity.Vo;

import lombok.Data;

/**
 * @author wangyangyang
 * @description: 用于返回风险学生数据类
 * @date: 2022/6/9 12:48
 */
@Data
public class RiskStudent {
    String temperatureId;
    String temperatureValue;
    String temperatureAddress;
    String temperatureSymptom;
    String temperatureCreadeTime;
    String userId;
    String name;
    String phone;
}
