package com.example.trainee_online_back.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.Temperature;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.trainee_online_back.entity.Vo.RiskStudent;

/**
* @author wangyangyang
* @description 针对表【temperature(体温表)】的数据库操作Service
* @createDate 2022-06-08 10:43:31
*/
public interface TemperatureService extends IService<Temperature> {
    JSONObject getRiskStudent(BaseQueryDto baseQueryDto);
}
