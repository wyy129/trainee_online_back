package com.example.trainee_online_back.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Temperature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trainee_online_back.entity.Vo.RiskStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyangyang
 * @description 针对表【temperature(体温表)】的数据库操作Mapper
 * @createDate 2022-06-08 10:43:31
 * @Entity com.example.trainee_online_back.entity.Temperature
 */
public interface TemperatureMapper extends BaseMapper<Temperature> {
    /**
     * @desc: 分页获取所有风险学生
     * @author: wangyangyang
     * @date: 2022-07-21 11:12:16
     * @return: 风险学生
     **/
    Page<RiskStudent> getRiskStudent(Page<RiskStudent> riskStudentPage);

    /**
     * @desc: 根据班级id列表获取这些班级下的学生体温信息
     * @author: wangyangyang
     * @date: 2022-07-21 11:19:48
     * @return: 学生体温信息
     **/
    List<RiskStudent> getRiskStudentByClassId(@Param("classIdList") List<String> classIdList);
}




