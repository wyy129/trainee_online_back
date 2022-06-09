package com.example.trainee_online_back.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Temperature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trainee_online_back.entity.Vo.RiskStudent;

/**
* @author wangyangyang
* @description 针对表【temperature(体温表)】的数据库操作Mapper
* @createDate 2022-06-08 10:43:31
* @Entity com.example.trainee_online_back.entity.Temperature
*/
public interface TemperatureMapper extends BaseMapper<Temperature> {

    Page<RiskStudent> getRiskStudent(Page<RiskStudent> riskStudentPage );
}




