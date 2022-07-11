package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.annotation.Role;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.Temperature;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.TemperatureService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import com.example.trainee_online_back.utils.VerifyUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangyangyang
 * @description: 体温记录相关控制器
 * @date: 2022/6/14 10:42
 * @return:
 */
@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    /**
     * @description: 添加体温记录
     * @author wangyangyang
     * @date: 2022/6/14 11:11
     * @return: 添加的条数
     */
    @RequestMapping("/addtemperature")
    public JSONObject addTemperature(@RequestBody Temperature temperature) {
        Integer userId = temperature.getUserId();
        String isRisk = temperature.getIsRisk();
        String temperatureValue = temperature.getTemperatureValue();
        String temperatureAddress = temperature.getTemperatureAddress();
        String temperatureSymptom = temperature.getTemperatureSymptom();
        VerifyUserUtil.verifyOperationUser(String.valueOf(userId));
        if (StringUtils.isEmpty(isRisk) || StringUtils.isEmpty(temperatureValue) || StringUtils.isEmpty(temperatureAddress) || StringUtils.isEmpty(temperatureSymptom)) {
            throw new ParameterException("参数不能为空");
        }
        int i = temperatureService.addTemperature(temperature);
        return ResponseUtil.returnSuccess("成功添加i条体温记录", i);
    }

    /**
     * @desc: 分页获取风险学生记录（未完成，应该是导员查询自己本班级所有风险学生）
     * @author wangyangyang
     * @date: 2022/6/14 11:19
     * @return: 风险学生体温记录列表
     */
    @Role("2")
    @RequestMapping("/getriskstudent")
    public JSONObject getRiskStudent(BaseQueryDto baseQueryDto) {
        JSONObject riskStudent = temperatureService.getRiskStudent(baseQueryDto);
        return ResponseUtil.returnSuccess("所有风险学生", riskStudent);
    }

    /**
     * @description: 根据用户id删除风险学生体温记录
     * @author wangyangyang
     * @date: 2022/6/10 8:31
     * @return: 返回删除的条数
     */
    @RequestMapping("/deleteriskstudentbyid")
    public JSONObject deleteRiskStudentById(@RequestBody Map map) {
        String userid = map.get("userId").toString();
        VerifyUserUtil.verifyOperationUser(userid);
        int i = temperatureService.deleteRiskStudentByUserId(Integer.valueOf(userid));
        return ResponseUtil.returnSuccess("删除i条记录", i);
    }
}
