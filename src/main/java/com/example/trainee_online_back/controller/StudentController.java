package com.example.trainee_online_back.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.trainee_online_back.entity.Student;
import com.example.trainee_online_back.mapper.StudentMapper;
import com.example.trainee_online_back.utils.JsonResult;
import com.example.trainee_online_back.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 学生控制层
 *
 * @author wyy
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    JsonResult jsonResult = new JsonResult();
    @Autowired
    private StudentMapper studentMapper;

    /**
     * @desc: 登录逻辑方法
     * @author: wyy
     * @date: 2022-05-10 20:55:39
     * @param: null
     * @return: null
     **/
    @RequestMapping("/login")
    public JsonResult login(@RequestBody JSONObject jsonObject) {
        String student_name = (String) jsonObject.get("student_name");
        String student_password = (String) jsonObject.get("student_password");
        Map<String, Object> map = new HashMap<>();
        map.put("student_username", student_name);
        map.put("student_password", student_password);
        List<Student> students = studentMapper.selectByMap(map);
        Student student = null;
        try {
            student = students.get(0);
        } catch (Exception e) {
            return jsonResult.error("登录失败");
        }
        if (student != null) {
            String s = JSON.toJSONString(student);
            String token = JwtUtils.createToken(s);
            System.out.println(token);
            String audience = JwtUtils.getAudience(token);
            JSONObject stu = JSON.parseObject(audience);
            System.out.println("json" + stu);
        }
        return jsonResult.success(student);
    }
}
