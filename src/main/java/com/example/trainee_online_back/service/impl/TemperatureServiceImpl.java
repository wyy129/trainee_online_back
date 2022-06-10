package com.example.trainee_online_back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.Temperature;
import com.example.trainee_online_back.entity.Vo.RiskStudent;
import com.example.trainee_online_back.service.TemperatureService;
import com.example.trainee_online_back.mapper.TemperatureMapper;
import com.example.trainee_online_back.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【temperature(体温表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class TemperatureServiceImpl extends ServiceImpl<TemperatureMapper, Temperature>
        implements TemperatureService {
    @Autowired
    private TemperatureMapper temperatureMapper;

    /**
     * @description: 分页获取所有风险学生
     * @author wangyangyang
     * @date: 2022/6/10 8:29
     */
    @Override
    public JSONObject getRiskStudent(BaseQueryDto baseQueryDto) {
        Page<RiskStudent> riskStudentPage = new Page<>(baseQueryDto.getPage(), baseQueryDto.getPageSize());
        Page<RiskStudent> riskStudent = temperatureMapper.getRiskStudent(riskStudentPage);
        return PageUtil.getPageData(riskStudent);
    }

    /**
     * @description: 根据用户id删除风险学生体温记录
     * @author wangyangyang
     * @date: 2022/6/10 8:31
     * @return: 返回删除的条数
     */
    @Override
    public Integer deleteRiskStudentById(Integer id) {
        QueryWrapper<Temperature> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        queryWrapper.eq("deleted", 0);
        queryWrapper.eq("is_risk", "1");
        int delete_num = temperatureMapper.delete(queryWrapper);
        return delete_num;
    }
}




