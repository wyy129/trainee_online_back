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
    /**
     * @description: 分页获取所有风险学生
     * @author wangyangyang
     * @date: 2022/6/10 8:29
     */
    JSONObject getRiskStudent(BaseQueryDto baseQueryDto);
    /**
     * @description: 根据用户id删除风险学生体温记录
     * @author wangyangyang
     * @date: 2022/6/10 8:31
     * @return: 返回删除的条数
     */
    Integer deleteRiskStudentById(Integer id);
}
