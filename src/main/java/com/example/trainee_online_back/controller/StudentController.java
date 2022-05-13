package com.example.trainee_online_back.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.trainee_online_back.entity.Student;
import com.example.trainee_online_back.mapper.StudentMapper;
import com.example.trainee_online_back.utils.JsonResult;
import com.example.trainee_online_back.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 学生控制层
 *
 * @author wyy
 */
@CrossOrigin
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
        System.out.println(jsonObject.toJSONString());
        String student_username = (String) jsonObject.get("student_username");
        String student_password = (String) jsonObject.get("student_password");
        Map<String, Object> map = new HashMap<>();
        map.put("student_username", student_username);
        map.put("student_password", student_password);
        Student student = null;
        try {
            List<Student> students = studentMapper.selectByMap(map);
            student = students.get(0);
        } catch (Exception e) {
            return jsonResult.error("登录失败");
        }
        String token = JwtUtils.createToken(student.getStudentId().toString());
        JSONObject result = new JSONObject();
        result.put("token", token);
        result.put("student", student);

        return jsonResult.success(result);
    }

    @RequestMapping("/test")
    public JsonResult test() {
        System.out.println("进入到测试方法");
        return jsonResult.success("jinru");
    }
}
