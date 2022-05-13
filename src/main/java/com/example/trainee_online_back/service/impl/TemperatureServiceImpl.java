package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.Temperature;
import com.example.trainee_online_back.service.TemperatureService;
import com.example.trainee_online_back.mapper.TemperatureMapper;
import org.springframework.stereotype.Service;

/**
* @author wyy
* @description 针对表【temperature(体温表)】的数据库操作Service实现
* @createDate 2022-05-11 21:06:56
*/
@Service
public class TemperatureServiceImpl extends ServiceImpl<TemperatureMapper, Temperature>
    implements TemperatureService{

}




